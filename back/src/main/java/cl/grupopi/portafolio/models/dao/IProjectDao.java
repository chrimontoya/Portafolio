package cl.grupopi.portafolio.models.dao;

import cl.grupopi.portafolio.models.entity.Project;
import org.springframework.data.repository.CrudRepository;

public interface IProjectDao extends CrudRepository<Project, Long> {
}
