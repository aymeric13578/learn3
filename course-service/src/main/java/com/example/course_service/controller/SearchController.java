package com.example.course_service.controller;

import com.example.course_service.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> searchCourses(@RequestParam(required = false) String title,
                                      @RequestParam(required = false) String description,
                                      @RequestParam(required = false) String instructor) {
        return courseService.searchCourses(title, description, instructor);
    }

    @GetMapping("/filter/courses")
    public List<Course> filterCourses(@RequestParam(required = false) Double minPrice,
                                      @RequestParam(required = false) Double maxPrice,
                                      @RequestParam(required = false) LocalDateTime startDate,
                                      @RequestParam(required = false) LocalDateTime endDate) {
        return courseService.filterCourses(minPrice, maxPrice, startDate, endDate);
    }
}


