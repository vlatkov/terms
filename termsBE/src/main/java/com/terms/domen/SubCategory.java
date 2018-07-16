package com.terms.domen;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Table(name = "sub_category")
public class SubCategory implements Serializable {

    static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "name")
    @Size(max = 255)
    private String name;

    @Column(nullable = true, name = "description")
    @Size(max = 255)
    private String description;

    @ManyToOne
    private Category category;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
