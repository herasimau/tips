package com.tips.registration.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author herasimau on 07.10.2016.
 */

@Entity
@Table(name = "user")
public class User {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;


    @NotNull
    @Size(min = 6, max = 100)
    private String password;
    @NotNull
    @Size(min = 1, max = 100)
    @Email
    private String email;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
