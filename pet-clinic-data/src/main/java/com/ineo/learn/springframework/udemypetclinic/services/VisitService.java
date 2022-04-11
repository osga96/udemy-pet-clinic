package com.ineo.learn.springframework.udemypetclinic.services;

import com.ineo.learn.springframework.udemypetclinic.modelPOJO.Visit;

public interface VisitService extends CrudService<Visit, Long> {

    void deleteById(Long id);
}
