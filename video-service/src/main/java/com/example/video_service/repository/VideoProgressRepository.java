package com.example.video_service.repository;

import com.example.video_service.model.VideoProgress;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VideoProgressRepository extends MongoRepository<VideoProgress, String> {

    VideoProgress findByUserIdAndVideoId(UUID userId, UUID videoId);

    List<VideoProgress> findByUserId(UUID userId);

    List<VideoProgress> findByVideoId(UUID videoId);
}
