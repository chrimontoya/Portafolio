package cl.grupopi.portafolio.controllers;

import cl.grupopi.portafolio.models.entity.Project;
import cl.grupopi.portafolio.services.project.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {
    @Autowired
    private ProjectServiceImpl projectServiceImpl;
    @PostMapping("")
    public void create(@RequestBody Project project){
        projectServiceImpl.save(project);
    }
    @GetMapping("")
    @Secured({"ROLE_ADMIN"})
    public Iterable<Project> getAll(){
        return projectServiceImpl.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Project> findById(@PathVariable Long id){ return projectServiceImpl.findById(id); }
    @DeleteMapping("/{id}")
    public void delete(@RequestBody Project project){
        projectServiceImpl.delete(project);
    }

}
