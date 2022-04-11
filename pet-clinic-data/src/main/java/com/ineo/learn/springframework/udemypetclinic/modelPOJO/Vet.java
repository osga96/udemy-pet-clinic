package com.ineo.learn.springframework.udemypetclinic.modelPOJO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Speciality> specialities;

    public Vet(String firstName, String lastName) {
        super(firstName, lastName);
        this.specialities = new HashSet<>();
    }

    public Vet() {

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
