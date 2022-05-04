package com.ineo.learn.springframework.udemypetclinic.services;

import com.ineo.learn.springframework.udemypetclinic.modelPOJO.PetType;

import java.util.Set;

public interface PetTypeService extends CrudService<PetType, Long> {
    void deleteById(Long id);
    Set<PetType> findAll();
}
