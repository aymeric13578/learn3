package com.example.course_service.repository;

import com.example.course_service.model.Course;

import java.util.List;
import java.util.UUID;
public interface CourseRepository extends JpaRepository<Course, UUID> {

    @Query("SELECT c FROM Course c WHERE c.title LIKE %:keyword% OR c.description LIKE %:keyword%")
    List<Course> searchByKeyword(String keyword);
}
