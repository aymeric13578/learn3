package com.example.course_service.service;

import com.example.course_service.model.ContentVersion;
import com.example.course_service.repository.ContentVersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class VersioningService {

    @Autowired
    private ContentVersionRepository contentVersionRepository;

    public ContentVersion createVersion(ContentVersion contentVersion) {
        return contentVersionRepository.save(contentVersion);
    }

    public List<ContentVersion> getVersionsByContentId(UUID contentId) {
        return contentVersionRepository.findByContentId(contentId);
    }
}

