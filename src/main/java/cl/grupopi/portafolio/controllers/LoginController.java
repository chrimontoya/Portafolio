package cl.grupopi.portafolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class LoginController {

    @GetMapping("/login")
    private String login(Model model){

        return "login";
    }
}
