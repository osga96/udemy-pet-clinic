package com.ineo.learn.springframework.udemypetclinic.repositories;

import com.ineo.learn.springframework.udemypetclinic.modelPOJO.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
