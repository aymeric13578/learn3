package com.example.course_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/courses/{courseId}/contents")
public class CourseContentController {

    @Autowired
    private CourseContentService courseContentService;

    @PostMapping
    public CourseContent addContent(@PathVariable UUID courseId, @RequestBody CourseContent content) {
        return courseContentService.addContent(courseId, content);
    }

    @PutMapping("/{contentId}")
    public CourseContent updateContent(@PathVariable UUID contentId, @RequestBody CourseContent content) {
        return courseContentService.updateContent(contentId, content);
    }

    @GetMapping("/{contentId}")
    public Optional<CourseContent> getContentById(@PathVariable UUID contentId) {
        return courseContentService.getContentById(contentId);
    }

    @GetMapping
    public List<CourseContent> getAllContents(@PathVariable UUID courseId) {
        return courseContentService.getAllContents(courseId);
    }

    @DeleteMapping("/{contentId}")
    public void deleteContent(@PathVariable UUID contentId) {
        courseContentService.deleteContent(contentId);
    }
}

