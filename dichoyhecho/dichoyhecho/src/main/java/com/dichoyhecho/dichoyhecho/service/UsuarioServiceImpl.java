package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.dto.CommentRequest;
import com.dichoyhecho.dichoyhecho.entity.Comment;
import com.dichoyhecho.dichoyhecho.entity.Usuario;
import com.dichoyhecho.dichoyhecho.exception.ResourceNotFound;
import com.dichoyhecho.dichoyhecho.repository.CommentRepository;
import com.dichoyhecho.dichoyhecho.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> list() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario GetById(Integer id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("User with Id not found:" + id));
    }

    @Override
    public Usuario create(Usuario usuario) {
        usuario.setId(null);
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Integer id, Usuario usuario) {
        Usuario existente = GetById(id);
        existente.setFirstName(usuario.getFirstName());
        existente.setLastName(usuario.getLastName());
        existente.setUserHandle(usuario.getUserHandle());
        existente.setPassword(usuario.getPassword());
        existente.setAge(usuario.getAge());
        existente.setUserRole(usuario.getUserRole());

        return usuarioRepository.save(existente);
    }

    @Override
    public void delete(Integer id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFound("User with ID not found: " + id);
        }
        usuarioRepository.deleteById(id);
    }

    @Service
    public class ComentarioService {

        @Autowired
        private CommentRepository comentarioRepository;

        @Autowired
        private UsuarioService usuarioService;

        public List<Comment> obtenerTodos() {
            return comentarioRepository.findAll();
        }

        public void guardarComentario(CommentRequest request) throws IOException {
            Usuario autor = usuarioService.GetById(request.getId().intValue());
            Comment nuevo = new Comment();
            nuevo.setContent(request.getContent());
            nuevo.setId(autor);


            if (request.getImagen() != null && !request.getImagen().isEmpty()) {
                nuevo.setImagen(request.getImagen().getBytes());
            }

            if (request.getVideo() != null && !request.getVideo().isEmpty()) {
                nuevo.setVideo(request.getVideo().getBytes());
            }

            comentarioRepository.save(nuevo);
        }
        public void eliminarComentario(Long commentId, Integer userIdQueBorra) {
            Comment comentario = comentarioRepository.findById(commentId)
                    .orElseThrow(() -> new RuntimeException("The comment does not exist."));

            if (comentario.getId().getId().longValue() != userIdQueBorra.longValue()) {
                throw new RuntimeException("You do not have permission to delete this comment.");
            }

            comentarioRepository.delete(comentario);
        }
    }
}