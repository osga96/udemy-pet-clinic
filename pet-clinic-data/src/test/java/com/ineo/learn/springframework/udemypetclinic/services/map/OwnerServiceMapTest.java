package com.ineo.learn.springframework.udemypetclinic.services.map;

import com.ineo.learn.springframework.udemypetclinic.modelPOJO.Owner;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    Long ownerId = 1L;
    String ownerLastName = "Pedro";

    // Se ejecuta SIEMPRE antes de cada método.
    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());

        Owner owner = new Owner();
        owner.setId(1L);
        owner.setLastName(ownerLastName);

        ownerServiceMap.save(owner);
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(1L);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void save() {
        Owner owner = new Owner();
        owner.setId(2L);

        Owner savedOwner = ownerServiceMap.save(owner);

        assertEquals(2L, owner.getId());

    }

    @Test
    void saveNoId() {
        Owner owner = new Owner();

        Owner savedOwner = ownerServiceMap.save(owner);

        assertNotNull(owner);
        assertNotNull(owner.getId());

        log.debug("Owner id: " + owner.getId());

    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner pedro = ownerServiceMap.findByLastName(ownerLastName);

        log.debug("ownerServiceMap.findById(1L).getLastName(); " + ownerServiceMap.findById(1L).getLastName());

        assertNotNull(pedro);

        assertEquals(ownerLastName, pedro.getLastName());
    }
}