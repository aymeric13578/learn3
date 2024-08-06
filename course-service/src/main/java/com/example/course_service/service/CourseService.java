package com.example.course_service.service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course createOrUpdateCourse(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> getCourseById(UUID courseId) {
        return courseRepository.findById(courseId);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void deleteCourse(UUID courseId) {
        courseRepository.deleteById(courseId);
    }

    public Course publishCourse(UUID courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow();
        course.setPublished(true);
        return courseRepository.save(course);
    }

    public Course unpublishCourse(UUID courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow();
        course.setPublished(false);
        return courseRepository.save(course);
    }


    public List<Course> searchCourses(String title, String description, String instructor) {
        // Implement search logic here
    }

    public List<Course> filterCourses(Double minPrice, Double maxPrice, LocalDateTime startDate, LocalDateTime endDate) {
        // Implement filter logic here
    }
}

