package cl.grupopi.portafolio.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity

public class UserAuth implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_auth")
    private Long idUserAuth;
    private String username;
    private String password;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at")
    private Date createAt;

    public Long getIdUserAuth() {
        return idUserAuth;
    }

    public void setIdUserAuth(Long idUserAuth) {
        this.idUserAuth = idUserAuth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
