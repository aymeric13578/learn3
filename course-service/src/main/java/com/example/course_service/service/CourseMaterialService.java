package com.example.course_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseMaterialService {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Autowired
    private CourseRepository courseRepository;

    public CourseMaterial addMaterial(UUID courseId, CourseMaterial material) {
        Course course = courseRepository.findById(courseId).orElseThrow();
        material.setCourse(course);
        return courseMaterialRepository.save(material);
    }

    public CourseMaterial updateMaterial(UUID materialId, CourseMaterial material) {
        CourseMaterial existingMaterial = courseMaterialRepository.findById(materialId).orElseThrow();
        existingMaterial.setMaterialType(material.getMaterialType());
        existingMaterial.setMaterialData(material.getMaterialData());
        return courseMaterialRepository.save(existingMaterial);
    }

    public Optional<CourseMaterial> getMaterialById(UUID materialId) {
        return courseMaterialRepository.findById(materialId);
    }

    public List<CourseMaterial> getAllMaterials(UUID courseId) {
        return courseMaterialRepository.findByCourseId(courseId);
    }

    public void deleteMaterial(UUID materialId) {
        courseMaterialRepository.deleteById(materialId);
    }
}

