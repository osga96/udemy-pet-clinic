package com.ineo.learn.springframework.udemypetclinic.services.map;

import com.ineo.learn.springframework.udemypetclinic.modelPOJO.Owner;
import com.ineo.learn.springframework.udemypetclinic.services.CrudService;
import com.ineo.learn.springframework.udemypetclinic.services.OwnerService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
