package com.example.course_service.controller;

import com.example.course_service.model.CourseMaterial;
import com.example.course_service.service.CourseMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/courses/{courseId}/materials")
public class CourseMaterialController {

    @Autowired
    private CourseMaterialService courseMaterialService;

    @PostMapping
    public CourseMaterial addMaterial(@PathVariable UUID courseId, @RequestBody CourseMaterial material) {
        return courseMaterialService.addMaterial(courseId, material);
    }

    @PutMapping("/{materialId}")
    public CourseMaterial updateMaterial(@PathVariable UUID materialId, @RequestBody CourseMaterial material) {
        return courseMaterialService.updateMaterial(materialId, material);
    }

    @GetMapping("/{materialId}")
    public Optional<CourseMaterial> getMaterialById(@PathVariable UUID materialId) {
        return courseMaterialService.getMaterialById(materialId);
    }

    @GetMapping
    public List<CourseMaterial> getAllMaterials(@PathVariable UUID courseId) {
        return courseMaterialService.getAllMaterials(courseId);
    }

    @DeleteMapping("/{materialId}")
    public void deleteMaterial(@PathVariable UUID materialId) {
        courseMaterialService.deleteMaterial(materialId);
    }
}
