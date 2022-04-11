package com.ineo.learn.springframework.udemypetclinic.services;

import com.ineo.learn.springframework.udemypetclinic.modelPOJO.PetType;

public interface PetTypeService extends CrudService<PetType, Long> {
    void deleteById(Long id);
}
