package com.example.video_service.service;

import com.example.course_service.model.Video;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "course-service")
public interface CourseClient {
    @GetMapping("/videos/{videoId}")
    Video getVideoById(@PathVariable("videoId") UUID videoId);
}
