package com.example.video_service.controller;

import com.example.course_service.model.Video;
import com.example.video_service.model.*;
import com.example.video_service.service.VideoProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/progress")
public class VideoProgressController {

    private final VideoProgressService videoProgressService;

    @Autowired
    public VideoProgressController(VideoProgressService videoProgressService) {
        this.videoProgressService = videoProgressService;
    }

    @PostMapping("/update")
    public ResponseEntity<VideoProgress> updateProgress(@RequestBody VideoProgress videoProgress) {
        Video videoDetails = videoProgressService.getVideoDetails(videoProgress.getVideoId());
        if (videoDetails == null) {
            return ResponseEntity.badRequest().build();
        }
        VideoProgress updatedProgress = videoProgressService.saveOrUpdateProgress(videoProgress);
        return ResponseEntity.ok(updatedProgress);
    }

    @GetMapping("/{userId}/{videoId}")
    public ResponseEntity<VideoProgress> getProgress(@PathVariable UUID userId, @PathVariable UUID videoId) {
        VideoProgress progress = videoProgressService.getProgress(userId, videoId);
        return progress != null ? ResponseEntity.ok(progress) : ResponseEntity.notFound().build();
    }

    @PostMapping("/sync")
    public ResponseEntity<Void> syncProgress(@RequestBody SyncProgressRequest request) {
        for (VideoProgress videoProgress : request.getProgressData()) {
            Video videoDetails = videoProgressService.getVideoDetails(videoProgress.getVideoId());
            if (videoDetails != null) {
                videoProgressService.saveOrUpdateProgress(videoProgress);
            }
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<VideoProgress>> getAllProgressForUser(@PathVariable UUID userId) {
        List<VideoProgress> progressList = videoProgressService.getAllProgressForUser(userId);
        return ResponseEntity.ok(progressList);
    }

    @DeleteMapping("/{userId}/{videoId}")
    public ResponseEntity<String> deleteProgress(@PathVariable UUID userId, @PathVariable UUID videoId) {
        videoProgressService.deleteProgress(userId, videoId);
        return ResponseEntity.ok("Progress deleted successfully");
    }

    @GetMapping("/summary/{videoId}")
    public ResponseEntity<ProgressSummary> getProgressSummary(@PathVariable UUID videoId) {
        ProgressSummary summary = videoProgressService.getProgressSummary(videoId);
        return ResponseEntity.ok(summary);
    }

    @GetMapping("/engagement/{userId}")
    public ResponseEntity<UserEngagement> getUserEngagementMetrics(@PathVariable UUID userId) {
        UserEngagement engagement = videoProgressService.getUserEngagementMetrics(userId);
        return ResponseEntity.ok(engagement);
    }

    @PostMapping("/realtime")
    public ResponseEntity<Void> realTimeProgressUpdate(@RequestBody VideoProgress videoProgress) {
        Video videoDetails = videoProgressService.getVideoDetails(videoProgress.getVideoId());
        if (videoDetails != null) {
            videoProgressService.saveOrUpdateProgress(videoProgress);
        }
        return ResponseEntity.ok().build();
    }
}
