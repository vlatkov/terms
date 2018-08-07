package com.terms.domen;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "place_info")
public class PlaceInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Place place;

    @Column(name = "price")
    private float price;

    @Column(name = "number_participants")
    private Long numberParticipants;

    @Column(name = "place_type")
    private String placeType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
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
}
