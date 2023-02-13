package cl.grupopi.portafolio.models.dao;

import cl.grupopi.portafolio.models.entity.Contact;
import org.springframework.data.repository.CrudRepository;

public interface IContactDao extends CrudRepository<Contact, Long> {
}
