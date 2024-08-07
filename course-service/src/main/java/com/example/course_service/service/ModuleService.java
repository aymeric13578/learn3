package com.example.course_service.service;

import com.example.course_service.model.Course;
import com.example.course_service.model.Module;
import com.example.course_service.repository.CourseRepository;
import com.example.course_service.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Module addModule(UUID courseId, Module module) {
        Course course = courseRepository.findById(courseId).orElseThrow();
        module.setCourse(course);
        return moduleRepository.save(module);
    }

    public Module updateModule(UUID moduleId, Module module) {
        Module existingModule = moduleRepository.findById(moduleId).orElseThrow();
        existingModule.setTitle(module.getTitle());
        existingModule.setContent(module.getContent());
        existingModule.setOrder(module.getOrder());
        return moduleRepository.save(existingModule);
    }

    public Optional<Module> getModuleById(UUID moduleId) {
        return moduleRepository.findById(moduleId);
    }

    public List<Module> getAllModules(UUID courseId) {
        return moduleRepository.findByCourseId(courseId);
    }

    public void deleteModule(UUID moduleId) {
        moduleRepository.deleteById(moduleId);
    }
}
