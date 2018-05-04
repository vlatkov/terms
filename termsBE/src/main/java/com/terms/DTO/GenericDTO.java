package com.terms.DTO;

import javax.management.Attribute;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.springframework.util.Assert.notNull;

public class GenericDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, Attribute> attributes = null;

    private Map<String, Set<GenericDTO>> relations = null;

    private String name = null;

    public GenericDTO(){}

    public GenericDTO(String name) {

        notNull(name, "The name of the DTO cannot be null...");

        this.attributes = new HashMap<String, Attribute>();

        this.relations = new HashMap<String, Set<GenericDTO>>();

        this.name = name;

    }

    public GenericDTO add(String name, Attribute attribute) {

        notNull(name, "Attribute name cannot be null");

        notNull(attribute, "Attribute with name: " + name + " is null!");

        this.attributes.put(name, attribute);

        return this;

    }

}