package com.example.activity_service.service;

import com.example.activity_service.model.Activity;
import com.example.activity_service.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private KafkaTemplate<String, Activity> kafkaTemplate;

    private static final String ACTIVITY_TOPIC = "activity-topic";

    public void logActivity(Activity activity) {
        // Save activity to database
        activityRepository.save(activity);

        // Publish activity to Kafka
        kafkaTemplate.send(ACTIVITY_TOPIC, activity);
    }

    public List<Activity> getActivitiesByUserId(String userId) {
        return activityRepository.findByUserId(userId);
    }

    // Additional methods for generating reports and real-time analytics
}
