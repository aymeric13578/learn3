package com.example.course_service.service;

import com.example.course_service.model.Course;
import com.example.course_service.model.CourseContent;
import com.example.course_service.repository.CourseContentRepository;
import com.example.course_service.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseContentService {

    @Autowired
    private CourseContentRepository courseContentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public CourseContent addContent(UUID courseId, CourseContent content) {
        Course course = courseRepository.findById(courseId).orElseThrow();
        content.setCourse(course);
        return courseContentRepository.save(content);
    }

    public CourseContent updateContent(UUID contentId, CourseContent content) {
        CourseContent existingContent = courseContentRepository.findById(contentId).orElseThrow();
        existingContent.setContentType(content.getContentType());
        existingContent.setContentData(content.getContentData());
        return courseContentRepository.save(existingContent);
    }

    public Optional<CourseContent> getContentById(UUID contentId) {
        return courseContentRepository.findById(contentId);
    }

    public List<CourseContent> getAllContents(UUID courseId) {
        return courseContentRepository.findByCourseId(courseId);
    }

    public void deleteContent(UUID contentId) {
        courseContentRepository.deleteById(contentId);
    }
}


