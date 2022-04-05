package com.ineo.learn.springframework.udemypetclinic.bootstrap;

import com.ineo.learn.springframework.udemypetclinic.modelPOJO.*;
import com.ineo.learn.springframework.udemypetclinic.services.PetTypeService;
import com.ineo.learn.springframework.udemypetclinic.services.SpecialityService;
import com.ineo.learn.springframework.udemypetclinic.testdatasource.FakeDataSource;
import com.ineo.learn.springframework.udemypetclinic.services.OwnerService;
import com.ineo.learn.springframework.udemypetclinic.services.VetService;
import com.ineo.learn.springframework.udemypetclinic.testdatasource.TestConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BootStrapData implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final FakeDataSource fakeDataSource;
    private final TestConfiguration testConfiguration;

    public BootStrapData(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, FakeDataSource fakeDataSource, TestConfiguration testConfiguration) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.fakeDataSource = fakeDataSource;
        this.testConfiguration = testConfiguration;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        /*Pet types*/
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        /*Owners / pets*/
        Owner owner1 = new Owner("Persona 1", "Apellido1");
        owner1.setAddress("test calle 123");
        owner1.setCity("ciudad 1");
        owner1.setTelephone("123 123 123");

        Pet pet1 = new Pet();
        pet1.setPetType(savedDogPetType);
        pet1.setOwner(owner1);
        pet1.setBirthDate(LocalDate.now());
        pet1.setName("biscuit");

        owner1.getPets().add(pet1);

        /*owner1.setId(0L);*/
        ownerService.save(owner1);
        Owner owner2 = new Owner("Persona 2", "Apellido2");
        owner2.setAddress("test calle 123");
        owner2.setCity("ciudad 1");
        owner2.setTelephone("123123123");
        owner2.getPets().add(pet1);
        /*owner2.setId(1L);*/
        ownerService.save(owner2);
        Owner owner3 = new Owner("Persona 3", "Apellido3");
        owner3.setAddress("calle 2332");
        owner3.setCity("ciudad 2");
        owner3.setTelephone("1241231246");


        Pet pet2 = new Pet();
        pet2.setPetType(savedCatPetType);
        pet2.setOwner(owner3);
        pet2.setBirthDate(LocalDate.now());
        pet2.setName("michi");

        owner3.getPets().add(pet2);

        /*owner3.setId(2L);*/
        ownerService.save(owner3);

        /*Specialties / vets*/

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        specialityService.save(dentistry);

        Vet vet1 = new Vet("Veterinario 1", "Apellido1");
        vet1.setId(0L);
        vet1.getSpecialities().add(radiology);
        Vet vet2 = new Vet("Veterinario 2", "Apellido2");
        vet2.setId(1L);
        vet2.getSpecialities().add(surgery);
        Vet vet3 = new Vet("Veterinario 3", "Apellido3");
        vet3.setId(2L);
        vet3.getSpecialities().add(dentistry);

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
