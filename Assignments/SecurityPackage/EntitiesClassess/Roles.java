package com.naukriforsagar.NaukriForSagar.SecurityPackage.EntitiesClassess;

import jakarta.persistence.*;

@Entity
@Table(name="roles")
public class Roles {
    @Id
    @Column(name = "roleid")
    private Long roleid;
    @Column(name="name")
    private String name;

    public Roles() {
    }

    public Long getId() {
        return roleid;
    }

    public void setId(Long id) {
        this.roleid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
