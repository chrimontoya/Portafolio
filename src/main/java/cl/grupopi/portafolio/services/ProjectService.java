package cl.grupopi.portafolio.services;

import cl.grupopi.portafolio.dao.IProjectDao;
import cl.grupopi.portafolio.models.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService implements IProjectDao {

    @Override
    public void create(Project project) {

    }

    @Override
    public void update(Project project) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Project getById(Long id) {
        return null;
    }

    @Override
    public List<Project> getAll() {
        return null;
    }
}
