package com.terms.domen;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "comment")
public class Comment implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private RegistrationPlace registrationPlace;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "value")
    private String value;

    @Column(name = "liked")
    private int liked;

    @Column(name = "unliked")
    private int unLiked;

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

    public RegistrationPlace getRegistrationPlace() {
        return registrationPlace;
    }

    public void setRegistrationPlace(RegistrationPlace registrationPlace) {
        this.registrationPlace = registrationPlace;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getLiked() {
        return liked;
    }

    public void setLiked(int liked) {
        this.liked = liked;
    }

    public int getUnLiked() {
        return unLiked;
    }

    public void setUnLiked(int unLiked) {
        this.unLiked = unLiked;
    }
}

