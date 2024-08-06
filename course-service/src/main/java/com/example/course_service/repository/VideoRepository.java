package com.example.course_service.repository;

import com.example.course_service.model.Video;

import java.util.List;
import java.util.UUID;

@Repository
public interface VideoRepository extends JpaRepository<Video, UUID> {
    List<Video> findByCourseContentId(UUID contentId);
}
