package com.ineo.learn.springframework.udemypetclinic.repositories;

import com.ineo.learn.springframework.udemypetclinic.modelPOJO.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
