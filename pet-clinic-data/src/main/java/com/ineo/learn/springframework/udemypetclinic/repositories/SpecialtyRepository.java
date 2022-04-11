package com.ineo.learn.springframework.udemypetclinic.repositories;

import com.ineo.learn.springframework.udemypetclinic.modelPOJO.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}
