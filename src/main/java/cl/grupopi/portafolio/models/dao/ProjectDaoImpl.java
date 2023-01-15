package cl.grupopi.portafolio.models.dao;

import cl.grupopi.portafolio.models.entity.ProjectEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProjectDaoImpl implements IProjectDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public List<ProjectEntity> getAll() {
        return entityManager.createQuery("FROM ProjectEntity").getResultList();
    }
    @Transactional(readOnly = true)
    @Override
    public ProjectEntity getById(Long id) {
        return (ProjectEntity) entityManager.createQuery("FROM ProjectEntity WHERE id ==" + id).getResultList();
    }

    @Override
    public void create() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
