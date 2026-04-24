package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.Problem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProblemService {

    List<Problem> list();
    Problem create(Problem problemas);
    Problem update(Integer id, Problem problemas);
    void delete(Integer id);

}
