package com.ineo.learn.springframework.udemypetclinic.bootstrap;

import com.ineo.learn.springframework.udemypetclinic.modelPOJO.PetType;
import com.ineo.learn.springframework.udemypetclinic.services.PetTypeService;
import com.ineo.learn.springframework.udemypetclinic.testdatasource.FakeDataSource;
import com.ineo.learn.springframework.udemypetclinic.modelPOJO.Owner;
import com.ineo.learn.springframework.udemypetclinic.modelPOJO.Vet;
import com.ineo.learn.springframework.udemypetclinic.services.OwnerService;
import com.ineo.learn.springframework.udemypetclinic.services.VetService;
import com.ineo.learn.springframework.udemypetclinic.testdatasource.TestConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final FakeDataSource fakeDataSource;
    private final TestConfiguration testConfiguration;

    public BootStrapData(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, FakeDataSource fakeDataSource, TestConfiguration testConfiguration) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.fakeDataSource = fakeDataSource;
        this.testConfiguration = testConfiguration;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner("Persona 1", "Apellido1");
        /*owner1.setId(0L);*/
        ownerService.save(owner1);
        Owner owner2 = new Owner("Persona 2", "Apellido2");
        /*owner2.setId(1L);*/
        ownerService.save(owner2);
        Owner owner3 = new Owner("Persona 3", "Apellido3");
        /*owner3.setId(2L);*/
        ownerService.save(owner3);

        Vet vet1 = new Vet("Veterinario 1", "Apellido1");
        vet1.setId(0L);
        Vet vet2 = new Vet("Veterinario 2", "Apellido2");
        vet2.setId(1L);
        Vet vet3 = new Vet("Veterinario 3", "Apellido3");
        vet3.setId(2L);

        vetService.save(vet1);
        vetService.save(vet2);
        vetService.save(vet3);

        System.out.println("Listing all Owners");

        //LAMBDA Y NO LAMBDA

        ownerService.findAll().forEach(owner -> System.out.println("Owner is: " + owner.toString()));

        System.out.println("Listing all Vets");

        vetService.findAll().forEach(vet -> {
            System.out.println("Vet is: " + vet.toString());
        });

        System.out.println("usr: " + fakeDataSource.getUsername());
        System.out.println("pwd: " + fakeDataSource.getPassword());
        System.out.println("jdbc: " + fakeDataSource.getJdbcUrl());

        System.out.println("testMatch: " + testConfiguration.getUsername());
        System.out.println("testMatch: " + testConfiguration.getPassword());
        System.out.println("testMatch: " + testConfiguration.getJdbcUrl());

    }

}
