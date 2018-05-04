package com.terms.domen;

import javax.persistence.*;
import java.io.Serializable;

public class Component implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Role role;

    @Column(name = "name")
    private String name;

    @Column(name = "visible")
    private Boolean visible;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "attribute")
    private String attribute;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    @Override
    public String toString() {
        return "Component{" +
                "id=" + id +
                ", role=" + role +
                ", name='" + name + '\'' +
                ", visible=" + visible +
                ", active=" + active +
                ", attribute='" + attribute + '\'' +
                '}';
    }

}
