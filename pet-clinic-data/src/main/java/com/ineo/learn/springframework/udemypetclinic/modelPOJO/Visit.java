package com.ineo.learn.springframework.udemypetclinic.modelPOJO;

import java.time.LocalDate;

public class Visit extends BaseEntity {

    public LocalDate date;
    public String description;
    public Pet pet;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
