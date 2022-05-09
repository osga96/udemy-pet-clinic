package com.ineo.learn.springframework.udemypetclinic.services.springdatajpa;

import com.ineo.learn.springframework.udemypetclinic.modelPOJO.Owner;
import com.ineo.learn.springframework.udemypetclinic.repositories.OwnerRepository;
import com.ineo.learn.springframework.udemypetclinic.repositories.PetRepository;
import com.ineo.learn.springframework.udemypetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSpringDataJpaServiceTest {

    public static final String TEST = "test";
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSpringDataJpaService ownerSpringDataJpaService;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(TEST).build();
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(returnOwner);
        ownerSet.add(Owner.builder().id(2L).firstName("testtest").lastName("test2").build());
        when(ownerRepository.findAll()).thenReturn(ownerSet);

        assertNotNull(ownerRepository.findAll());
        assertEquals(2, ((Set<Owner>) ownerRepository.findAll()).size());
    }

    @Test
    void findByLastName() {
        returnOwner.setId(1L);
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner test = ownerSpringDataJpaService.findByLastName(TEST);

        assertEquals(TEST, test.getLastName());
        verify(ownerRepository).findByLastName(any());

    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        Owner owner = ownerSpringDataJpaService.findById(1L);

        assertEquals(1L, owner.getId());
    }

    @Test
    void save() {
        //when save return owner
    }

    @Test
    void delete() {
        //verify ownerspdarepo delete any()
    }
}