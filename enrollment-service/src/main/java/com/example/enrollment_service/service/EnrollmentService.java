package com.example.enrollment_service.service;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public Enrollment enrollUser(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }
}
