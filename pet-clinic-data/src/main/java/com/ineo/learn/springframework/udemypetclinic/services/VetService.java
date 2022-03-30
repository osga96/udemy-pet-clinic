package com.ineo.learn.springframework.udemypetclinic.services;

import com.ineo.learn.springframework.udemypetclinic.modelPOJO.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet pet);

    Set<Vet> findAll();
}
