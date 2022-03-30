package com.ineo.learn.springframework.udemypetclinic.services;

import com.ineo.learn.springframework.udemypetclinic.modelPOJO.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastName);
    Owner findById(Long id);
    Owner save(Owner owner);

    Set<Owner> findAll();

}
