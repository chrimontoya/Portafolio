package cl.grupopi.portafolio.controllers;

import cl.grupopi.portafolio.models.entity.Contact;
import cl.grupopi.portafolio.services.contact.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactController {
    @Autowired
    private ContactServiceImpl contactService;

    @PostMapping("")
    public void create(@RequestBody Contact contact){
        contactService.save(contact);
    }
    @GetMapping("")
    public Iterable<Contact> getAll(){
        return contactService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Contact> findById(@PathVariable Long id){ return contactService.findById(id); }
    @DeleteMapping("/{id}")
    public void delete(@RequestBody Contact contact){
        contactService.delete(contact);
    }
}
