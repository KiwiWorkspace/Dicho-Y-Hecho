package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.dto.CommentRequest;
import com.dichoyhecho.dichoyhecho.entity.Comments;
import com.dichoyhecho.dichoyhecho.entity.Users;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CommentService {
    List<Comments> list();
    Comments findById(Integer id);
    Comments create(Comments comment);
    Comments update(Integer id, Comments comment);
    void delete(Integer id);

    void save(String content, Integer idZone, Users user, MultipartFile file);
    void guardarComentario(CommentRequest request) throws IOException;
    void eliminarComentario(Long commentId, Integer userIdQueBorra);
}