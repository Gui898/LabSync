package com.labSync.LabSync.controller;

import com.labSync.LabSync.models.Project;
import com.labSync.LabSync.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ProjectController implements ProtocolMethods<Project>{

    ProjectService projectService;

    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @Override
    @PostMapping
    public ResponseEntity<Project> post(@RequestBody Project project) {
        Project added = projectService.addProject(project);
        return ResponseEntity.status(201).body(added);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        projectService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Project> put(@PathVariable long id, @RequestBody Project project) {
        project.setIdProject(id);
        Project edited = projectService.updateProject(project);
        return ResponseEntity.ok(edited);
    }

    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<Project> patch(@PathVariable long id, @RequestBody Project project) {
        project.setIdProject(id);
        Project edited = projectService.updateProject(project);
        return ResponseEntity.ok(edited);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Project> getById(@PathVariable long id) {
        return ResponseEntity.ok(projectService.getProjectByTitle(id));
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<Project> getByTitle(@PathVariable String title){
        String alterdTitle = title.replace("-", " ");
        return ResponseEntity.ok(projectService.getProjectByTitle(alterdTitle));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Project>> getAllByUserId(@PathVariable long id) {
        return ResponseEntity.ok(projectService.getProjectsByUserId(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Project>> getAll() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }
}
