package cl.grupopi.portafolio.models.dao;

import cl.grupopi.portafolio.models.entity.UserAuth;
import org.springframework.data.repository.CrudRepository;
public interface IUserDetailsDao extends CrudRepository<UserAuth, Integer> {
    UserAuth findUserAuthByUsername(String username);
}
