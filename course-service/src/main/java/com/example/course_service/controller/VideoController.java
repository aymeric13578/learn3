package com.example.course_service.controller;

import com.example.course_service.model.Video;
import com.example.course_service.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/contents/{contentId}/videos")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping
    public Video addVideo(@PathVariable UUID contentId, @RequestBody Video video) {
        return videoService.addVideo(contentId, video);
    }

    @PutMapping("/{videoId}")
    public Video updateVideo(@PathVariable UUID videoId, @RequestBody Video video) {
        return videoService.updateVideo(videoId, video);
    }

    @GetMapping("/{videoId}")
    public Optional<Video> getVideoById(@PathVariable UUID videoId) {
        return videoService.getVideoById(videoId);
    }

    @GetMapping
    public List<Video> getAllVideos(@PathVariable UUID contentId) {
        return videoService.getAllVideos(contentId);
    }

    @DeleteMapping("/{videoId}")
    public void deleteVideo(@PathVariable UUID videoId) {
        videoService.deleteVideo(videoId);
    }
}
