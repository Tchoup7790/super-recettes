package com.group.SuperSteps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group.SuperSteps.model.dao.Step;

public interface StepRepository extends JpaRepository<Step, String> {
}
