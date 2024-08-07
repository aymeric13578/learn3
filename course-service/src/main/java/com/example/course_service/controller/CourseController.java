package com.example.course_service.controller;

import com.example.course_service.model.Course;
import com.example.course_service.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.createOrUpdateCourse(course);
    }

    @PutMapping("/{courseId}")
    public Course updateCourse(@PathVariable UUID courseId, @RequestBody Course course) {
        course.setCourseId(courseId);
        return courseService.createOrUpdateCourse(course);
    }

    @GetMapping("/{courseId}")
    public Optional<Course> getCourseById(@PathVariable UUID courseId) {
        return courseService.getCourseById(courseId);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable UUID courseId) {
        courseService.deleteCourse(courseId);
    }

    @PostMapping("/{courseId}/publish")
    public Course publishCourse(@PathVariable UUID courseId) {
        return courseService.publishCourse(courseId);
    }

    @PostMapping("/{courseId}/unpublish")
    public Course unpublishCourse(@PathVariable UUID courseId) {
        return courseService.unpublishCourse(courseId);
    }
}


