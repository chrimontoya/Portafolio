package cl.grupopi.portafolio.services.contact;

import cl.grupopi.portafolio.models.entity.Contact;

import java.util.Optional;

public interface IContactService {

    void save(Contact contact);
    Iterable<Contact> findAll();
    Optional<Contact> findById(Long id);
    void delete(Contact contact);
}
