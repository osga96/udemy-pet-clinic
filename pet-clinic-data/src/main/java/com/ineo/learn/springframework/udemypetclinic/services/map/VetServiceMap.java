package com.ineo.learn.springframework.udemypetclinic.services.map;

import com.ineo.learn.springframework.udemypetclinic.modelPOJO.Vet;
import com.ineo.learn.springframework.udemypetclinic.services.CrudService;
import com.ineo.learn.springframework.udemypetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    void deleteById(Long id) {
        super.deleteById(id);
    }
}
