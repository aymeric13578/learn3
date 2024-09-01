package com.example.video_service.model;

import java.util.List;
import java.util.UUID;

public class SyncProgressRequest {

    private UUID userId;
    private List<VideoProgress> progressData;

    // Getters and Setters
    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public List<VideoProgress> getProgressData() {
        return progressData;
    }

    public void setProgressData(List<VideoProgress> progressData) {
        this.progressData = progressData;
    }
}
