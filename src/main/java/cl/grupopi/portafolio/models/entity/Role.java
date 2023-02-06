package cl.grupopi.portafolio.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "AUTHORITIES", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_user_auth","authority"})})
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Long id;
    private String authority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
