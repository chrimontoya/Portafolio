package cl.grupopi.portafolio.services.jpaServices;

import cl.grupopi.portafolio.models.dao.IUserDetailsDao;
import cl.grupopi.portafolio.models.entity.Role;
import cl.grupopi.portafolio.models.entity.UserAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("jpaUserDetailsService")
public class JpaUserDetailsServices implements UserDetailsService {
    @Autowired
    private IUserDetailsDao userDetailsDao;

    private Logger logger = LoggerFactory.getLogger(JpaUserDetailsServices.class);
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuth userAuth = userDetailsDao.findUserAuthByUsername(username);

        if(userAuth == null){
            logger.error("Error login: no existe usuario ${userAuth}");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        System.out.println(userAuth.getRoles());
        for(Role role: userAuth.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }

        return new User(userAuth.getUsername(), userAuth.getPassword(), userAuth.getEnabled(), true, true, true, authorities);
    }
}
