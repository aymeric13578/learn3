package com.example.course_service.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/courses/{courseId}/modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @PostMapping
    public Module addModule(@PathVariable UUID courseId, @RequestBody Module module) {
        return moduleService.addModule(courseId, module);
    }

    @PutMapping("/{moduleId}")
    public Module updateModule(@PathVariable UUID moduleId, @RequestBody Module module) {
        return moduleService.updateModule(moduleId, module);
    }

    @GetMapping("/{moduleId}")
    public Optional<Module> getModuleById(@PathVariable UUID moduleId) {
        return moduleService.getModuleById(moduleId);
    }

    @GetMapping
    public List<Module> getAllModules(@PathVariable UUID courseId) {
        return moduleService.getAllModules(courseId);
    }

    @DeleteMapping("/{moduleId}")
    public void deleteModule(@PathVariable UUID moduleId) {
        moduleService.deleteModule(moduleId);
    }
}

