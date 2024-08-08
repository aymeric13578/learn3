package com.example.activity_service.controller;

import com.example.activity_service.model.Activity;
import com.example.activity_service.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping
    public void logActivity(@RequestBody Activity activity) {
        activityService.logActivity(activity);
    }

    @GetMapping("/{userId}")
    public List<Activity> getUserActivities(@PathVariable String userId) {
        return activityService.getActivitiesByUserId(userId);
    }
}
