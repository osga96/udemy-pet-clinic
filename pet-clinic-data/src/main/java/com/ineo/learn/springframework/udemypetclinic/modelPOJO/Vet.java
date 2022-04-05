package com.ineo.learn.springframework.udemypetclinic.modelPOJO;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {

    private Set<Speciality> specialities;

    public Vet(String firstName, String lastName) {
        super(firstName, lastName);
        this.specialities = new HashSet<>();
    }

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }

    @Override
    public String toString() {

        String specialitiesString = "";

        if (specialities != null) {
            for (Speciality speciality : specialities) {
                specialitiesString += speciality.getDescription() + " ";
            }
        }

        return "Vet{" +
                "specialities=" + specialitiesString +
                "firstName=" + super.getFirstName() +
                "lastName=" + super.getLastName() +
                '}';
    }
}
