package com.terms.domen;



import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.internal.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@Table(name = "region")
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "name")
    @Size(max = 256)
    private String name;

    @Column(name = "code")
    @Size(max = 256)
    private String code;

   /* @OneToMany(mappedBy = "region",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonBackReference
    private Set<Place> places = new HashSet<>();*/

    public Region(){}

  /*  public Set<Place> getPlaces() {
        return places;
    }

    public void setPlaces(Set<Place> places) {
        this.places = places;
    }*/


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", city=" + city +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
