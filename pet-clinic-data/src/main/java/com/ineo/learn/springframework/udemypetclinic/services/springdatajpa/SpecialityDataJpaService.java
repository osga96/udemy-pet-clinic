package com.ineo.learn.springframework.udemypetclinic.services.springdatajpa;

import com.ineo.learn.springframework.udemypetclinic.modelPOJO.Speciality;
import com.ineo.learn.springframework.udemypetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialityDataJpaService implements SpecialityService {

    private final SpecialityService specialityService;

    public SpecialityDataJpaService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Speciality> findAll() {

        return new HashSet<>(specialityService.findAll());
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialityService.findById(aLong);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityService.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialityService.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        specialityService.deleteById(id);
    }
}
