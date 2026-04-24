package com.dichoyhecho.dichoyhecho.repository;

import com.dichoyhecho.dichoyhecho.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository extends JpaRepository<Problem, Integer> {
}
