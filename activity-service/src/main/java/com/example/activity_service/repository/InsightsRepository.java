package com.example.activity_service.repository;

import com.example.activity_service.model.Insights;
import org.springframework.stereotype.Repository;

@Repository
public class InsightsRepository {

    public Insights getInsights() {
        // Logic to fetch insights from database or cache
        return new Insights();
    }
}
