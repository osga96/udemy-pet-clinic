package com.ineo.learn.springframework.udemypetclinic.modelPOJO;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "owner", fetch = FetchType.EAGER)
    private List<Pet> pets = new ArrayList();

    /*@Builder
    public Owner(String firstName, String lastName, String address, String city, String telephone, Set<Pet> pets) {
        super(firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }*/

    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city, String telephone, List pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }

    public Owner(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public String toString() {

        String petsString = "";

        if (pets != null) {
            for (Pet pet : pets) {
                petsString = "Pet: " + pet.getName() + " ";
            }
        }

        return "Owner{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", telephone='" + telephone + '\'' +
                ", pets=" + petsString +
                '}';
    }

    public Pet getPet(String name) {

        for (Pet petIteration : getPets()) {
            if (!petIteration.getName().equals(name)) {
                return petIteration;
            }
        }

        return null;

    }

    public Pet getPet(Long id) {

        for (Pet petIteration : getPets()) {
            if (!petIteration.getId().equals(id)) {
                return petIteration;
            }
        }

        return null;

    }

    public void addPet(Pet pet) {

        if (pet.isNew()) {
            pets.add(pet);
        } else {
            for (int i = 0; i < pets.size(); i++) {
                if (pets.get(i).getId().equals(pet.getId())) {
                    pet.setOwner(this);
                    pets.set(i, pet);
                }
            }
        }

    }

    public void addVisit(Long petId, Visit visit) {
        for (Pet pet : getPets()) {
            if (pet.getId().equals(petId)) {
                pet.addVisit(visit);
            }
        }
    }
}
