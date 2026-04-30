package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.Problems;
import com.dichoyhecho.dichoyhecho.exception.ResourceNotFound;
import com.dichoyhecho.dichoyhecho.repository.ProblemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemServiceImpl implements ProblemService {

    private ProblemRepository ProblemRepository;

    public ProblemServiceImpl(ProblemRepository ProblemRepository) {
        this.ProblemRepository = ProblemRepository;
    }

    @Override
    public List<Problems> list() {
        return ProblemRepository.findAll();
    }

    @Override
    public Problems create(Problems problemas) {
        problemas.setId(null);
        return ProblemRepository.save(problemas);
    }

    @Override
    public Problems update(Integer id, Problems problemas) {
        problemas.setId(id);
        return ProblemRepository.save(problemas);
    }

    @Override
    public void delete(Integer id) {
        if(!ProblemRepository.existsById(id)){
            throw new ResourceNotFound("Problem with ID not found " + id);
        }
        ProblemRepository.deleteById(id);
    }
}
