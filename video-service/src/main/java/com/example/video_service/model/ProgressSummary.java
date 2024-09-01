package com.example.video_service.model;

import java.util.UUID;

public class ProgressSummary {

    private UUID videoId;
    private int averageWatchedDuration;
    private float completionRate;

    public ProgressSummary(UUID videoId, int averageWatchedDuration, float completionRate) {
        this.videoId = videoId;
        this.averageWatchedDuration = averageWatchedDuration;
        this.completionRate = completionRate;
    }

    // Getters and Setters
    public UUID getVideoId() {
        return videoId;
    }

    public void setVideoId(UUID videoId) {
        this.videoId = videoId;
    }

    public int getAverageWatchedDuration() {
        return averageWatchedDuration;
    }

    public void setAverageWatchedDuration(int averageWatchedDuration) {
        this.averageWatchedDuration = averageWatchedDuration;
    }

    public float getCompletionRate() {
        return completionRate;
    }

    public void setCompletionRate(float completionRate) {
        this.completionRate = completionRate;
    }
}