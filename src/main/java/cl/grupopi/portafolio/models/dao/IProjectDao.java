package cl.grupopi.portafolio.models.dao;

import cl.grupopi.portafolio.models.Project;

import java.util.List;

public interface IProjectDao {
    List<Project> getAll();
    Project getById(Long id);
    void create();
    void update();
    void delete();
}
