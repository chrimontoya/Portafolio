package cl.grupopi.portafolio.controllers;

import cl.grupopi.portafolio.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {

    @Value("${titulo.home}")
    private String homeTitle;

    @GetMapping({"/index","","/home"})
    public String index(ModelMap modelMap){

        List<String> navButtons = new ArrayList<>();

        navButtons.add("Christian Montoya");
        navButtons.add("Proyectos");
        navButtons.add("Contacto");
        navButtons.add("Acerca de");


        modelMap.addAttribute("titulo", homeTitle);
        modelMap.addAttribute("navButtons",navButtons);
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
}
