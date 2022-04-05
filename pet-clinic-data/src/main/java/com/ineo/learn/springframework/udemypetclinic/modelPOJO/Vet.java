package com.ineo.learn.springframework.udemypetclinic.modelPOJO;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {

    private Set<Speciality> specialities;

    public Vet(String firstName, String lastName) {
        super(firstName, lastName);
        this.specialities = new HashSet<>();
    }
}
