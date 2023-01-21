package cl.grupopi.portafolio.services.contact;

import cl.grupopi.portafolio.models.dao.IContactDao;
import cl.grupopi.portafolio.models.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ContactServiceImpl implements IContactService {
    @Autowired
    private IContactDao iContactDao;

    @Override
    @Transactional
    public void save(Contact contact) {
        iContactDao.save(contact);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Contact> findAll() {
        return iContactDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Contact> findById(Long id) {
        return iContactDao.findById(id);
    }

    @Override
    @Transactional
    public void delete(Contact contact) {
        iContactDao.delete(contact);
    }
}
