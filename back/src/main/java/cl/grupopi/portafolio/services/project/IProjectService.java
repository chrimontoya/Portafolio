package cl.grupopi.portafolio.services.project;

import cl.grupopi.portafolio.models.entity.Project;
import java.util.Optional;

public interface IProjectService {
    void save(Project project);
    Iterable<Project> findAll();
    Optional<Project> findById(Long id);
    void delete(Project project);

}
