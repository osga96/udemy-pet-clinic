package com.ineo.learn.springframework.udemypetclinic.services.springdatajpa;

import com.ineo.learn.springframework.udemypetclinic.modelPOJO.Pet;
import com.ineo.learn.springframework.udemypetclinic.repositories.PetRepository;
import com.ineo.learn.springframework.udemypetclinic.services.PetService;
import org.springframework.context.annotation.Profile;

import java.util.HashSet;
import java.util.Set;

@Profile("springdatajpa")
public class PetSpringDataJpaService implements PetService {

    private final PetRepository petRepository;

    public PetSpringDataJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();

        petRepository.findAll().forEach(pets::add);

        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
