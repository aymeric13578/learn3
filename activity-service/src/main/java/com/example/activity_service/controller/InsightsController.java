package com.example.activity_service.controller;

import com.example.activity_service.model.Insights;
import com.example.activity_service.service.InsightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insights")
public class InsightsController {

    @Autowired
    private InsightsService insightsService;

    @GetMapping
    public Insights getInsights() {
        return insightsService.getInsights();
    }
}