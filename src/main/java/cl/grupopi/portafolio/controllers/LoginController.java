package cl.grupopi.portafolio.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/api/v1")
public class LoginController {

    @PostMapping ("/login")
    private void login(Authentication authentication){
        System.out.println(authentication.isAuthenticated());
    }
}
