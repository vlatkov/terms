package com.terms.domen;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by vlatko on 13.7.18..
 */
@Entity
@Table(name = "category")
public class Category implements Serializable  {

    static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "name")
    @Size(max = 255)
    private String name;

    @Column(name = "description")
    @Size(max = 255)
    private String description;


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
