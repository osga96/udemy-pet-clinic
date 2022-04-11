package com.ineo.learn.springframework.udemypetclinic.repositories;

import com.ineo.learn.springframework.udemypetclinic.modelPOJO.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
