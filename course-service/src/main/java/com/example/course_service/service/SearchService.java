package com.example.course_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> searchCourses(String keyword) {
        return courseRepository.searchByKeyword(keyword);
    }
}

