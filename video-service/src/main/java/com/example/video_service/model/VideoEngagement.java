package com.example.video_service.model;

import java.util.UUID;

public class VideoEngagement {

    private UUID videoId;
    private int watchedDuration;

    public VideoEngagement(UUID videoId, int watchedDuration) {
        this.videoId = videoId;
        this.watchedDuration = watchedDuration;
    }

    // Getters and Setters
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
}
