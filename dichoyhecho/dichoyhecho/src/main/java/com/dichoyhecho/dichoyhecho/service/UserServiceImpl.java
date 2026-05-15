package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.dto.CommentRequest;
import com.dichoyhecho.dichoyhecho.entity.Comments;
import com.dichoyhecho.dichoyhecho.entity.Users;
import com.dichoyhecho.dichoyhecho.exception.ResourceNotFound;
import com.dichoyhecho.dichoyhecho.repository.CommentRepository;
import com.dichoyhecho.dichoyhecho.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Users> list() {
        return userRepository.findAll();
    }

    @Override
    public Users getById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with Id not found:" + id));
    }

    @Override
    public Users create(Users usuario) {
        usuario.setIdUser(null);
        return userRepository.save(usuario);
    }

    @Override
    public Users update(Integer id, Users users) {
        Users existente = getById(id);
        existente.setFirstName(users.getFirstName());
        existente.setLastName(users.getLastName());
        existente.setUserHandle(users.getUserHandle());
        existente.setProfileImg(users.getProfileImg());
        existente.setPassword(users.getPassword());
        existente.setAgeUser(users.getAgeUser());
        existente.setUserRole(users.getUserRole());

        return userRepository.save(existente);
    }

    @Override
    public void delete(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFound("User with ID not found: " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public Users getByHandle(String handle) {
        return userRepository.findByUserHandle(handle)
                .orElseThrow(() -> new ResourceNotFound("User with handle not found: " + handle));
    }

    @Override
    public Users getByEmail(String email) {
        return userRepository.findByEmailUser(email)
                .orElseThrow(() -> new ResourceNotFound("User with email not found: " + email));
    }

    @Service
    public class CommentService {

        @Autowired
        private CommentRepository commentRepository;

        @Autowired
        private UserService userService;

        public List<Comments> obtenerTodos() {
            return commentRepository.findAll();
        }

        public void guardarComentario(CommentRequest request) throws IOException {

            Users autor = userService.getById(request.getUserId().intValue());

            Comments nuevo = new Comments();
            nuevo.setContent(request.getContent());
            nuevo.setIdUser(autor);

            // guarda la zona
            nuevo.setIdZone(request.getIdZone());

            if (request.getImage() != null && !request.getImage().isEmpty()) {
                nuevo.setImagen(request.getImage().getBytes());
            }
            if (request.getVideo() != null && !request.getVideo().isEmpty()) {
                nuevo.setVideo(request.getVideo().getBytes());
            }
            commentRepository.save(nuevo);
        }
        public void eliminarComentario(Long commentId, Integer userIdQueBorra) {
            Comments comments = commentRepository.findById(commentId)
                    .orElseThrow(() -> new RuntimeException("The comment does not exist."));

            if (comments.getIdUser().getIdUser().longValue() != userIdQueBorra.longValue()) {
                throw new RuntimeException("You do not have permission to delete this comment.");
            }

            commentRepository.delete(comments);
        }
    }
}