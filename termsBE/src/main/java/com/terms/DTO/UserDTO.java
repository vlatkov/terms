package com.terms.DTO;

import com.terms.domen.City;
import com.terms.domen.Region;
import com.terms.domen.User;

import java.io.Serializable;
public class UserDTO implements Serializable {

    private User user;
    private Region region;
    private City city;

    public UserDTO(User user, Region region, City city){
        this.user = user;

        this.region = region;
        this.city = city;
    }
}
