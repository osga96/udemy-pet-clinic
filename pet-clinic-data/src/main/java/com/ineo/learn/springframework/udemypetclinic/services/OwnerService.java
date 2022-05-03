package com.ineo.learn.springframework.udemypetclinic.services;

import com.ineo.learn.springframework.udemypetclinic.modelPOJO.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastName(String lastName);

}
