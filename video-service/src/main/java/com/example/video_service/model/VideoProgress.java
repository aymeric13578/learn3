package com.example.video_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document(collection = "video_progress")
public class VideoProgress {

    @Id
    private String id; // MongoDB requires String for the @Id field

    private UUID userId;
    private UUID videoId;
    private int watchedDuration; // Duration in seconds
    private LocalDateTime lastWatched;

    // Constructors
    public VideoProgress() {}

    public VideoProgress(UUID userId, UUID videoId, int watchedDuration, LocalDateTime lastWatched) {
        this.userId = userId;
        this.videoId = videoId;
        this.watchedDuration = watchedDuration;
        this.lastWatched = lastWatched;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getVideoId() {
        return videoId;
    }

    public void setVideoId(UUID videoId) {
        this.videoId = videoId;
    }

    public int getWatchedDuration() {
        return watchedDuration;
    }

    public void setWatchedDuration(int watchedDuration) {
        this.watchedDuration = watchedDuration;
    }

    public LocalDateTime getLastWatched() {
        return lastWatched;
    }

    public void setLastWatched(LocalDateTime lastWatched) {
        this.lastWatched = lastWatched;
    }
}