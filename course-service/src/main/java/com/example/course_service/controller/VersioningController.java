package com.example.course_service.controller;

import com.example.course_service.model.ContentVersion;
import com.example.course_service.service.VersioningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/versions")
public class VersioningController {

    @Autowired
    private VersioningService versioningService;

    @PostMapping
    public ContentVersion createVersion(@RequestBody ContentVersion contentVersion) {
        return versioningService.createVersion(contentVersion);
    }

    @GetMapping("/{contentId}")
    public List<ContentVersion> getVersionsByContentId(@PathVariable UUID contentId) {
        return versioningService.getVersionsByContentId(contentId);
    }
}

