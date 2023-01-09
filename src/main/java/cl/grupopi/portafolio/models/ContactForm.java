package cl.grupopi.portafolio.models;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;

@Component
public class ContactForm {

    @NotEmpty
    private String name;
    @NotEmpty
    private String email;
    @NotEmpty
    private String message;

    public ContactForm(String name, String email, String message) {
        this.name = name;
        this.email = email;
        this.message = message;
    }

    public ContactForm(){
        this.name = "";
        this.email = "";
        this.message = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
