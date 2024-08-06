package com.example.course_service.controller;

import com.example.course_service.model.ContentVersion;
import com.example.course_service.model.CourseContent;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/contents/{contentId}/versions")
public class ContentVersionController {

    @Autowired
    private ContentVersionService contentVersionService;

    @PostMapping
    public ContentVersion createVersion(@PathVariable UUID contentId, @RequestBody ContentVersion version) {
        return contentVersionService.createVersion(contentId, version);
    }

    @GetMapping
    public List<ContentVersion> getAllVersions(@PathVariable UUID contentId) {
        return contentVersionService.getAllVersions(contentId);
    }

    @PostMapping("/{versionId}/restore")
    public CourseContent restoreVersion(@PathVariable UUID contentId, @PathVariable UUID versionId) {
        return contentVersionService.restoreVersion(contentId, versionId);
    }
}

