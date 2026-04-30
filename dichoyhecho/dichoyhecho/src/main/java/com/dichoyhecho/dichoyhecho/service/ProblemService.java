package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.Problems;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProblemService {

    List<Problems> list();
    Problems create(Problems problemas);
    Problems update(Integer id, Problems problemas);
    void delete(Integer id);

}