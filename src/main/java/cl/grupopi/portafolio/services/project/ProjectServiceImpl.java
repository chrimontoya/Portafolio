package cl.grupopi.portafolio.services.project;

import cl.grupopi.portafolio.models.dao.IProjectDao;
import cl.grupopi.portafolio.models.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements IProjectService{

    @Autowired
    private IProjectDao iProjectDao;
    @Override
    @Transactional
    public void save(Project project) {
        iProjectDao.save(project);
    }
    @Override
    @Transactional(readOnly = true)
    public Iterable<Project> findAll() {
        return iProjectDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Project> findById(Long id) {
        return iProjectDao.findById(id);
    }
    @Override
    @Transactional
    public void delete(Project project) {
        iProjectDao.delete(project);
    }
}
