package cl.grupopi.portafolio.controllers;

import cl.grupopi.portafolio.models.dao.ProjectDaoImpl;
import cl.grupopi.portafolio.models.entity.ProjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/app/projects")
public class ProjectController {

    @Autowired
    private ProjectDaoImpl projectDaoImpl;

    @GetMapping("")
    public String index(Model model){
        return "project";
    }

    @PostMapping("/agregar")
    public RedirectView addProject(@Valid ProjectEntity projectEntity, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("");
        if(!bindingResult.hasErrors()){
            projectEntity.setCreationAt(new Date());
            projectDaoImpl.create(projectEntity);
            return redirectView;
        }else{
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(err -> {
                errors.put(err.getField(),"El campo " + err.getField() + err.getDefaultMessage());
            });
            return redirectView;
        }
    }

    @ModelAttribute("projects")
    public List<ProjectEntity> getAll(){
        List<ProjectEntity> projectEntityList;
        projectEntityList = projectDaoImpl.getAll();
        return projectEntityList;
    }

}
