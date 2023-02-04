package cl.grupopi.portafolio.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginContext;
import javax.servlet.ServletRequest;
import java.security.Principal;

@Controller
@RequestMapping("/api/v1")
public class LoginController {

  /*  @PostMapping ("/login")
    private void login(@RequestParam String username,Authentication authentication){
        System.out.println(username);
    }*/
}
