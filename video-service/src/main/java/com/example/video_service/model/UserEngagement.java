package com.example.video_service.model;

import java.util.List;
import java.util.UUID;

public class UserEngagement {

    private UUID userId;
    private int totalWatchedDuration;
    private List<VideoEngagement> mostWatchedVideos;

    public UserEngagement(UUID userId, int totalWatchedDuration, List<VideoEngagement> mostWatchedVideos) {
        this.userId = userId;
        this.totalWatchedDuration = totalWatchedDuration;
        this.mostWatchedVideos = mostWatchedVideos;
    }

    // Getters and Setters
    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public int getTotalWatchedDuration() {
        return totalWatchedDuration;
    }

    public void setTotalWatchedDuration(int totalWatchedDuration) {
        this.totalWatchedDuration = totalWatchedDuration;
    }

    public List<VideoEngagement> getMostWatchedVideos() {
        return mostWatchedVideos;
    }

    public void setMostWatchedVideos(List<VideoEngagement> mostWatchedVideos) {
        this.mostWatchedVideos = mostWatchedVideos;
    }
}
