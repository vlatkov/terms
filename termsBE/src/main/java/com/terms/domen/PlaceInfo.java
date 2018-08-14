package com.terms.domen;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "place_info")
public class PlaceInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "price")
    private float price;

    @Column(name = "number_participants")
    private Long numberParticipants;

    @Column(name = "place_type")
    private String placeType;

 /*   @OneToMany(mappedBy = "placeInfo",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnore
    private Set<Place> places = new HashSet<>();*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Long getNumberParticipants() {
        return numberParticipants;
    }

    public void setNumberParticipants(Long numberParticipants) {
        this.numberParticipants = numberParticipants;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    @Override
    public String toString() {
        return "PlaceInfo{" +
                "id=" + id +
                ", price=" + price +
                ", numberParticipants=" + numberParticipants +
                ", placeType='" + placeType + '\'' +
                '}';
    }
}
