package com.ineo.learn.springframework.udemypetclinic.modelPOJO;

import javax.persistence.*;
import java.time.LocalDate;

public class Pet extends BaseEntity {
    private String name;
    private Owner owner;
    private PetType petType;
    private LocalDate birthDate;

    public Pet() {
    }

    public Pet(String name, PetType petType, LocalDate birthDate) {
        this.name = name;
        this.petType = petType;
        this.birthDate = birthDate;
    }

    public Pet(String name, Owner owner, PetType petType, LocalDate birthDate) {
        this.name = name;
        this.owner = owner;
        this.petType = petType;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
