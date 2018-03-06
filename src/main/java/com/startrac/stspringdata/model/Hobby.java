package com.startrac.stspringdata.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    
    @ManyToMany(mappedBy = "hobbies")
    private Set<Hipster> hipsters = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Hipster> getHipsters() {
        return hipsters;
    }

    public void setHipsters(Set<Hipster> hipsters) {
        this.hipsters = hipsters;
    }

}
