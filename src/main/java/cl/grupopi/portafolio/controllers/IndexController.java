package cl.grupopi.portafolio.controllers;

import cl.grupopi.portafolio.models.Project;
import cl.grupopi.portafolio.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {

    @Value("${titulo.home}")
    private String homeTitle;

    @Value("${titulo.portada}")
    private String title;
    @Value("${subtitulo.portada}")
    private String subTitle;
    @Value("${seccion.proyectos}")
    private String sectionProjects;
    @Value("${seccion.habilidades}")
    private String sectionSkills;
    @Value("${seccion.info}")
    private String sectionInfo;
    @Value("${seccion.form}")
    private String sectionForm;
    @Value("${seccion.form.txt}")
    private String sectionFormTxt;

    @Autowired
    private ProjectService projectService;

    @GetMapping({"/index","","/home"})
    public String index(ModelMap modelMap){

        modelMap.addAttribute("title", title);
        modelMap.addAttribute("subTitle", subTitle);
        modelMap.addAttribute("sectionProjects", sectionProjects);
        modelMap.addAttribute("sectionSkills", sectionSkills);
        modelMap.addAttribute("sectionInfo", sectionInfo);
        modelMap.addAttribute("sectionForm", sectionForm);
        modelMap.addAttribute("sectionFormTxt", sectionFormTxt);


        return "index";
    }
    @ModelAttribute("projects")
    public List<Project> getAll(){
        List<Project> projectList = new ArrayList<Project>();

        Project project = new Project();
        Project project2 = new Project();

        project.setIdProject(1);
        project.setName("Cocinando para mi");
        project.setDescription("Aplicaciøn que permite a usuarios a aprender a cocinar");
        project.setName_business("Grupo PI");
        project.setCreation_date(new Date());

        projectList.add(project);

        project2.setIdProject(2);
        project2.setName("Automotora messi");
        project2.setDescription("Autos de messi");
        project2.setName_business("Grupo PI");
        project2.setCreation_date(new Date());

        projectList.add(project2);

        return projectList;
    }

/*    @ModelAttribute("contact")
    public void sendContact(@PathVariable String name, @at){

    }*/
}
