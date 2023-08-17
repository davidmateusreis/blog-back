package com.david.blog.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class User {

    @Id
    private String userName;
    @NotBlank(message = "This field may not be blank")
    private String userFirstName;
    @NotBlank(message = "This field may not be blank")
    private String userLastName;
    @Email
    @NotBlank(message = "This field may not be blank")
    private String userEmail;
    @NotBlank(message = "This field may not be blank")
    private String userPassword;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE", joinColumns = {
            @JoinColumn(name = "USER_ID")
    }, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID")
    })
    private Set<Role> role;
}