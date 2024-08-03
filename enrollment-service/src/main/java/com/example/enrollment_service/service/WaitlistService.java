package com.example.enrollment_service.service;


@Service
public class WaitlistService {
    @Autowired
    private WaitlistRepository waitlistRepository;

    public Waitlist addToWaitlist(Waitlist waitlist) {
        return waitlistRepository.save(waitlist);
    }

    // Additional methods for waitlist management
}
