package com.ineo.learn.springframework.udemypetclinic.services.map;

import com.ineo.learn.springframework.udemypetclinic.modelPOJO.Pet;
import com.ineo.learn.springframework.udemypetclinic.services.CrudService;
import com.ineo.learn.springframework.udemypetclinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    void deleteById(Long id) {
        super.deleteById(id);
    }
}
