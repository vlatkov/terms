package com.terms.domen;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "name")
    @Size(max = 100)
    private String name;

    @Column(name = "code")
    @Size(max = 20)
    private String code;

    @Column(name = "flag_url")
    @Size(max = 256)
    private String flagUrl;

   /* @OneToMany(mappedBy = "country")
    private List<City> cities;*/

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFlagUrl() {
        return flagUrl;
    }

    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl;
    }

    public Country() {
    }
}
