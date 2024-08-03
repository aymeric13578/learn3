package com.example.enrollment_service.controller;

@RestController
@RequestMapping("/waitlist")
public class WaitlistController {
    @Autowired
    private WaitlistService waitlistService;

    @PostMapping
    public Waitlist addToWaitlist(@RequestBody Waitlist waitlist) {
        return waitlistService.addToWaitlist(waitlist);
    }

    // Additional endpoints for waitlist management
}
