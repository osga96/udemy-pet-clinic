package com.ineo.learn.springframework.udemypetclinic.services.springdatajpa;

import com.ineo.learn.springframework.udemypetclinic.modelPOJO.Speciality;
import com.ineo.learn.springframework.udemypetclinic.repositories.SpecialtyRepository;
import com.ineo.learn.springframework.udemypetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialityDataJpaService implements SpecialityService {

        private final SpecialtyRepository specialtyRepository;

    public SpecialityDataJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Speciality> findAll() {

        Set<Speciality> specialities = new HashSet<>();

        specialtyRepository.findAll().forEach(specialities::add);

        return specialities;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }
}
