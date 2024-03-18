package com.spring.cloud.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id")
            ,inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<RoleEntity> roles;
}
