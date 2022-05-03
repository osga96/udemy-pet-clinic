package com.ineo.learn.springframework.udemypetclinic.controllers;

import com.ineo.learn.springframework.udemypetclinic.modelPOJO.Owner;
import com.ineo.learn.springframework.udemypetclinic.repositories.OwnerRepository;
import com.ineo.learn.springframework.udemypetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;
    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerController controller;

    Set<Owner> owners;
    List<Owner> listOfOwners;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        listOfOwners = new ArrayList<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        listOfOwners.add(Owner.builder().id(1L).build());
        listOfOwners.add(Owner.builder().id(2L).build());
        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    void listOwners() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);

        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/find/index"))
                .andExpect(model().attribute("owners", hasSize(2)));

    }

    @Test
    void displayOwner() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(Owner.builder().id(1L).build());

        mockMvc.perform(get("/owners/123"))
                .andExpect(status().isOk())
                .andExpect(view().name("/owners/ownerDetails"))
                .andExpect(model().attribute("owner", hasProperty("id", is(1L))));
    }

    /*@Test
    void findOwnersAndReturnMany() throws Exception {
        when(ownerRepository.findAllByLastName(anyString())).thenReturn(listOfOwners);

        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("/owners/findOwners"))
                .andExpect(model().attribute("owners", hasSize(2)));

    }

    @Test
    void findOwnersAndReturnOne() throws Exception {
        when(ownerService.findByLastName(anyString())).thenReturn(Owner.builder().id(1L).build());

        mockMvc.perform(get("/owners/123"))
                .andExpect(status().isOk())
                .andExpect(view().name("/owners/ownerDetails"))
                .andExpect(model().attribute("owner", hasProperty("id", is(1L))));
    }*/

}