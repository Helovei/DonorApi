package com.helovei.donorApi.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class RoleEntity implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;
    @Getter
    @Setter
    private String name;

    @Transient
    @ManyToMany(mappedBy = "roles")
    @Setter
    @Getter
    private Set<UserEntity> users;

    public RoleEntity() {
    }

    public RoleEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public String getAuthority() {
        return getName();
    }
}
