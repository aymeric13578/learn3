package com.example.course_service.repository;

import com.example.course_service.model.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, UUID> {
    List<CourseMaterial> findByCourseId(UUID courseId);
}

