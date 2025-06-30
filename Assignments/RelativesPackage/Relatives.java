package com.second.secondbatchVeer.relative;

import jakarta.persistence.*;

@Entity
@Table(name="relatives")
public class Relatives {
    @Id
    @Column(name="id")
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name, relation, nature;

    public Relatives() {
    }

    public Relatives(int id, String name, String relation, String nature) {
        this.id = id;
        this.name = name;
        this.relation = relation;
        this.nature = nature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }
}
