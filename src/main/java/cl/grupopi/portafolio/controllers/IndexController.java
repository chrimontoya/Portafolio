package cl.grupopi.portafolio.controllers;

import cl.grupopi.portafolio.models.ContactForm;
import cl.grupopi.portafolio.models.dao.IProjectDao;
import cl.grupopi.portafolio.models.entity.ProjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

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
    private IProjectDao iProjectDao;

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

    @PostMapping("/contact")
    public String responseForm(@Valid ContactForm contactForm, BindingResult result, ModelMap model){
        model.addAttribute("title", title);
        model.addAttribute("subTitle", subTitle);
        model.addAttribute("sectionProjects", sectionProjects);
        model.addAttribute("sectionSkills", sectionSkills);
        model.addAttribute("sectionInfo", sectionInfo);
        model.addAttribute("sectionForm", sectionForm);
        model.addAttribute("sectionFormTxt", sectionFormTxt);

        if(result.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(err -> {
                errors.put(err.getField(), "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
            });
            model.addAttribute("error",errors);
            return "index";
        }

        model.addAttribute("title", "Contacto");
        model.addAttribute("message","Hola " + contactForm.getName() + " serás contactado lo más pronto posible :D");

        return "responseForm";
    }

    @ModelAttribute("test")
    public void test(){
        System.out.println("xd");
    }

    @ModelAttribute("projects")
    public List<ProjectEntity> getAllProjects(){
        List<ProjectEntity> projectEntities;
        projectEntities = iProjectDao.getAll();
        return projectEntities;
    }
}
