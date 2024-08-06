package com.example.course_service.repository;

import com.example.course_service.model.ContentVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface ContentVersionRepository extends JpaRepository<ContentVersion, UUID> {
    List<ContentVersion> findByContentId(UUID contentId);
    List<ContentVersion> findByCourseContentId(UUID contentId);
}
