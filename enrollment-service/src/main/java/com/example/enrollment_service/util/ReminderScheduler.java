package com.example.enrollment_service.util;

@Component
public class ReminderScheduler {
    @Scheduled(cron = "0 0 8 * * ?")
    public void sendReminders() {
        // Implementation to send automated reminders
    }
}
