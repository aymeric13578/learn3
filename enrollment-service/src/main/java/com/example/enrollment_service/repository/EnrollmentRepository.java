package com.example.enrollment_service.repository;

import com.example.enrollment_service.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EnrollmentRepository  extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByUser_UserId(UUID userId);
}
