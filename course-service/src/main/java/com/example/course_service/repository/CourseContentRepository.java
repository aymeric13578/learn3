package com.example.course_service.repository;

import com.example.course_service.model.CourseContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CourseContentRepository extends JpaRepository<CourseContent, UUID> {
    // Custom query methods if needed
    List<CourseContent> findByCourseId(UUID courseId);
}

