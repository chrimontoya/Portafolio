package cl.grupopi.portafolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")

public class IndexController {

    @GetMapping({"/index","","/home"})
    public String index(ModelMap modelMap){
        modelMap.addAttribute("titulo","Bienvenido a mi portafolio");
        return "index";
    }
}
