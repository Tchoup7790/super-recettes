package com.group.SuperRecipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group.SuperRecipes.model.dao.Step;

public interface StepRepository extends JpaRepository<Step, String> {
}
