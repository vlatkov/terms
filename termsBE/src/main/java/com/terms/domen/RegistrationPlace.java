package com.terms.domen;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "registration_playground")
public class RegistrationPlace implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne
    private User user;

    @NotNull
    @ManyToOne
    private Place place;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "valid_from")
    private Date validFrom;

    @Column(name = "valid_to")
    private Date validTo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    @Override
    public String toString() {
        return "RegistrationPlayground{" +
                "id=" + id +
                ", user=" + user +
                ", place=" + place +
                ", active=" + active +
                ", dateCreated=" + dateCreated +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                '}';
    }

}
