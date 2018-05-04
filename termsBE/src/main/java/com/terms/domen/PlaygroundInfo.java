package com.terms.domen;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "playground_info")
public class PlaygroundInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Playground playground;

    @Column(name = "price")
    private float price;

    @Column(name = "number_players")
    private Long numberPlayers;

    @Column(name = "playground_type")
    private String playgrounType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Playground getPlayground() {
        return playground;
    }

    public void setPlayground(Playground playground) {
        this.playground = playground;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Long getNumberPlayers() {
        return numberPlayers;
    }

    public void setNumberPlayers(Long numberPlayers) {
        this.numberPlayers = numberPlayers;
    }

    public String getPlaygrounType() {
        return playgrounType;
    }

    public void setPlaygrounType(String playgrounType) {
        this.playgrounType = playgrounType;
    }
}
