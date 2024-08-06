package com.example.course_service.service;

import com.example.course_service.model.CourseContent;
import com.example.course_service.model.Video;
import com.example.course_service.repository.CourseContentRepository;
import com.example.course_service.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private CourseContentRepository courseContentRepository;

    public Video addVideo(UUID contentId, Video video) {
        CourseContent content = courseContentRepository.findById(contentId).orElseThrow();
        video.setCourseContent(content);
        return videoRepository.save(video);
    }

    public Video updateVideo(UUID videoId, Video video) {
        Video existingVideo = videoRepository.findById(videoId).orElseThrow();
        existingVideo.setVideoUrl(video.getVideoUrl());
        existingVideo.setDuration(video.getDuration());
        return videoRepository.save(existingVideo);
    }

    public Optional<Video> getVideoById(UUID videoId) {
        return videoRepository.findById(videoId);
    }

    public List<Video> getAllVideos(UUID contentId) {
        return videoRepository.findByCourseContentId(contentId);
    }

    public void deleteVideo(UUID videoId) {
        videoRepository.deleteById(videoId);
    }
}


