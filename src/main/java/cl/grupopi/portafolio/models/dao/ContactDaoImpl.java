package cl.grupopi.portafolio.models.dao;

import cl.grupopi.portafolio.models.entity.ContactEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ContactDaoImpl implements ICrudDao <ContactEntity>{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public List<ContactEntity> getAll() {
        return entityManager.createQuery("FROM ContactEntity ").getResultList();
    }
    @Transactional(readOnly = true)
    @Override
    public ContactEntity getById(Long id) {
        return (ContactEntity) entityManager.createQuery("FROM ContactEntity WHERE id ==" + id).getResultList();
    }
    @Transactional
    @Override
    public void create(ContactEntity contactEntity) {
        entityManager.persist(contactEntity);
    }
    @Transactional
    @Override
    public void update(ContactEntity contactEntity) {
        entityManager.merge(contactEntity);
    }
    @Transactional
    @Override
    public void delete(ContactEntity contactEntity) {
        entityManager.remove(contactEntity);
    }
}
