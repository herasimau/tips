package com.tips.auth.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
/**
 * @author herasimau on 07.10.2016.
 */
@Entity
@Table(name = "authority")
public class Authority implements GrantedAuthority{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "authority_seq")
    @SequenceGenerator(name = "authority_seq", sequenceName = "authority_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", length = 50)
    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthorityName name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuthorityName getName() {
        return name;
    }

    public void setName(AuthorityName name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return this.name.toString();
    }
}
