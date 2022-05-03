package com.ineo.learn.springframework.udemypetclinic.repositories;

import com.ineo.learn.springframework.udemypetclinic.modelPOJO.Owner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastName(String lastName);

    @Query("SELECT DISTINCT owner FROM Owner owner left join  owner.pets WHERE owner.lastName LIKE :lastName%")
    @Transactional(readOnly = true)
    Page<Owner> findByLastNameQuery(@Param("lastName") String lastName, Pageable pageable);

}
