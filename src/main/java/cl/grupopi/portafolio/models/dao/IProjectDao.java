package cl.grupopi.portafolio.models.dao;

import cl.grupopi.portafolio.models.entity.ProjectEntity;

import java.util.List;

public interface IProjectDao {
    List<ProjectEntity> getAll();
    ProjectEntity getById(Long id);
    void create();
    void update();
    void delete();
}
