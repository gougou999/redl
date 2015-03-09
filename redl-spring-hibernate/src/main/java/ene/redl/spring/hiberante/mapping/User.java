package ene.redl.spring.hiberante.mapping;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zhangrui on 2014/7/7.
 */
@Entity
@Table(name="t_user")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Basic
    @Column(name="usernames", nullable = false, insertable = true, updatable = true)
    private String username;

    @Basic
    @Column(name="password", nullable = false, insertable = true, updatable = true)
    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
