package com.group.SuperSteps.controller;

import com.group.SuperSteps.model.dao.Step;
import com.group.SuperSteps.model.dto.CreateStepInput;
import com.group.SuperSteps.model.dto.UpdateStepInput;
import com.group.SuperSteps.service.StepService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/steps")
public class StepController {

    private final StepService stepService;

    public StepController(StepService stepService) {
        this.stepService = stepService;
    }

    @GetMapping
    public List<Step> getAllSteps() {
        return stepService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Step> getStep(@PathVariable String id) {
        return ResponseEntity.ok(stepService.findById(id));
    }

    @PostMapping
    public Step createStep(@RequestBody CreateStepInput step) {
        return stepService.save(step);
    }

    @PutMapping("/{id}")
    public Step updateStep(@PathVariable String id, @RequestBody UpdateStepInput step) {
        return stepService.update(id, step);
    }

    @DeleteMapping("/{id}")
    public void deleteStep(@PathVariable String id) {
        stepService.delete(id);
    }
}