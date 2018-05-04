package com.terms.domen;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "city")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

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
/*
    @OneToMany(mappedBy = "city")
    private Set<Region> regions = new HashSet<>();
*/
    @ManyToOne
    private Country country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "City{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", flagUrl='" + flagUrl + '\'' +
                ", country=" + country +
                '}';
    }

    public City() {
    }
}
