package com.example.course_service.service;

import com.example.course_service.model.ContentVersion;
import com.example.course_service.model.CourseContent;
import com.example.course_service.repository.ContentVersionRepository;
import com.example.course_service.repository.CourseContentRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ContentVersionService {

    @Autowired
    private ContentVersionRepository contentVersionRepository;

    @Autowired
    private CourseContentRepository courseContentRepository;

    public ContentVersion createVersion(UUID contentId, ContentVersion version) {
        CourseContent content = courseContentRepository.findById(contentId).orElseThrow();
        version.setCourseContent(content);
        return contentVersionRepository.save(version);
    }

    public List<ContentVersion> getAllVersions(UUID contentId) {
        return contentVersionRepository.findByCourseContentId(contentId);
    }

    public CourseContent restoreVersion(UUID contentId, UUID versionId) {
        ContentVersion version = contentVersionRepository.findById(versionId).orElseThrow();
        CourseContent content = courseContentRepository.findById(contentId).orElseThrow();
        content.setContentType(version.getContentType());
        content.setContentData(version.getContentData());
        return courseContentRepository.save(content);
    }
}

