package com.example.enrollment_service.controller;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public Enrollment enrollUser(@RequestBody Enrollment enrollment) {
        return enrollmentService.enrollUser(enrollment);
    }

    // Additional endpoints for enrollment management
}
