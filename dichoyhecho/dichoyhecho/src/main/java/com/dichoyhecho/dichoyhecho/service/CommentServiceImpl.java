package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.dto.CommentRequest;
import com.dichoyhecho.dichoyhecho.entity.Comments;
import com.dichoyhecho.dichoyhecho.entity.Users;
import com.dichoyhecho.dichoyhecho.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {


    @Autowired
    private CommentRepository commentRepository;

    private final UserService userService;

    // Usamos el constructor para inyectar el servicio de usuario de forma segura
    @Autowired
    public CommentServiceImpl(@Lazy UserService userService) {
        this.userService = userService;
    }

    @Override
    public Comments findById(Integer id) {
        return commentRepository.findById(id.longValue())
                .orElseThrow(() -> new RuntimeException("Comment not found with id: " + id));
    }

    @Override
    public Comments create(Comments comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comments update(Integer id, Comments comment) {
        commentRepository.save(comment);
        return comment;
    }

    @Override
    public void delete(Integer id) {
        commentRepository.deleteById(id.longValue());
    }

    @Override
    public List<Comments> list() {
        return commentRepository.findAll();
    }

    public void save(String content, Integer idZone, Users user, MultipartFile file) {
        Comments nuevo = new Comments();
        nuevo.setContent(content);
        nuevo.setIdZone(idZone);
        nuevo.setIdUser(user);

        if (file != null && !file.isEmpty()) {
            try {
                String contentType = file.getContentType();
                if (contentType != null && contentType.startsWith("image/")) {
                    nuevo.setImagen(file.getBytes());
                } else if (contentType != null && contentType.startsWith("video/")) {
                    nuevo.setVideo(file.getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        commentRepository.save(nuevo);
    }

    public void guardarComentario(CommentRequest request) throws IOException {
        Users autor = userService.getById(request.getUserId().intValue());
        Comments nuevo = new Comments();
        nuevo.setContent(request.getContent());
        nuevo.setIdUser(autor);
        nuevo.setIdZone(request.getIdZone());

        if (request.getImage() != null && !request.getImage().isEmpty()) {
            nuevo.setImagen(request.getImage().getBytes());
        }
        if (request.getVideo() != null && !request.getVideo().isEmpty()) {
            nuevo.setVideo(request.getVideo().getBytes());
        }
        commentRepository.save(nuevo);
    }

    public void eliminarComentario(Long commentId, Integer userIdDelete) {
        Comments comments = commentRepository.findById(commentId).orElse(null);

        if (comments == null) {
            return;
        }

        if (comments.getIdUser().getIdUser().longValue() != userIdDelete.longValue()) {
            throw new RuntimeException("You do not have permission to delete this comment.");
        }
        commentRepository.delete(comments);
    }

    @Override
    public List<Comments> findByUserId(Integer userId) {

        return commentRepository.findByIdUser_IdUser(userId);
    }
}