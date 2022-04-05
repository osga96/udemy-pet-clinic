package com.ineo.learn.springframework.udemypetclinic.modelPOJO;

import java.util.HashSet;
import java.util.Set;

public class Owner extends Person {

    private String address;
    private String city;
    private String telephone;
    private Set<Pet> pets = new HashSet<>();

    public Owner(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
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
}
