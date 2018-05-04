package com.terms.domen;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Table(name = "playground")
public class Playground implements Serializable {

    static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "location_lat")
    @NotNull
    private float latitudeLocation;

    @Column(name = "location_lng")
    @NotNull
    private float longitudeLocation;

    @ManyToOne
    private Region region;

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

    public float getLatitudeLocation() {
        return latitudeLocation;
    }

    public void setLatitudeLocation(float latitudeLocation) {
        this.latitudeLocation = latitudeLocation;
    }

    public float getLongitudeLocation() {
        return longitudeLocation;
    }

    public void setLongitudeLocation(float longitudeLocation) {
        this.longitudeLocation = longitudeLocation;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
