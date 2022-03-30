package com.ineo.learn.springframework.udemypetclinic.services;

import com.ineo.learn.springframework.udemypetclinic.modelPOJO.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet pet);

    Set<Pet> findAll();

}
