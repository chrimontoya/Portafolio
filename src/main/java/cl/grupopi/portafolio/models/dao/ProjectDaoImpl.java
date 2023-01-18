package cl.grupopi.portafolio.models.dao;

import cl.grupopi.portafolio.models.entity.ProjectEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProjectDaoImpl implements ICrudDao <ProjectEntity>{
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
        TypedQuery<ProjectEntity> query = entityManager.createQuery("FROM ProjectEntity WHERE id =" + id, ProjectEntity.class);
        return query.getSingleResult();
    }
    @Transactional
    @Override
    public void create(ProjectEntity projectEntity) {
        entityManager.persist(projectEntity);
    }
    @Transactional
    @Override
    public void update(ProjectEntity projectEntity) {
        entityManager.merge(projectEntity);
    }
    @Transactional
    @Override
    public void delete(ProjectEntity projectEntity) {
        entityManager.remove(projectEntity);
    }
}
