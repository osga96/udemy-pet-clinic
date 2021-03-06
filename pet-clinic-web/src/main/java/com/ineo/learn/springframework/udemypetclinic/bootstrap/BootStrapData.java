package com.ineo.learn.springframework.udemypetclinic.bootstrap;

import com.ineo.learn.springframework.udemypetclinic.modelPOJO.*;
import com.ineo.learn.springframework.udemypetclinic.services.*;
import com.ineo.learn.springframework.udemypetclinic.testdatasource.FakeDataSource;
import com.ineo.learn.springframework.udemypetclinic.testdatasource.TestConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BootStrapData implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialityService specialityService;
    private final VisitService visitService;
    private final FakeDataSource fakeDataSource;
    private final TestConfiguration testConfiguration;

    public BootStrapData(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService, SpecialityService specialityService, VisitService visitService, FakeDataSource fakeDataSource, TestConfiguration testConfiguration) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialityService = specialityService;
        this.visitService = visitService;
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
        owner3.setAddress("calle 2332 michigan");
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
        Owner owner4 = Owner.builder().firstName("Mismo apellido prueba").lastName("Apellido3").build();
        ownerService.save(owner4);

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

        Vet vet1 = new Vet("Veterinario 2", "Apellido2");
        vet1.setId(1L);
        vet1.getSpecialities().add(surgery);
        Vet vet2 = new Vet("Veterinario 3", "Apellido3");
        vet2.setId(2L);
        vet2.getSpecialities().add(dentistry);
        Vet vet3 = new Vet("Veterinario 4", "Apellido4");
        vet3.setId(3L);
        vet3.getSpecialities().add(dentistry);
        vet3.getSpecialities().add(surgery);
        vet3.getSpecialities().add(radiology);
        Vet vet4 = new Vet("Veterinario 5", "Apellido5");
        vet4.setId(4L);
        vet4.getSpecialities().add(dentistry);
        vet4.getSpecialities().add(radiology);

        vetService.save(vet1);
        vetService.save(vet2);
        vetService.save(vet3);
        vetService.save(vet4);

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

        Visit visit = new Visit();
        visit.setDescription("Visita 1");
        visit.setDate(LocalDate.now());
        visit.setPet(pet1);
        petService.save(pet1);
        petService.save(pet2);
        visitService.save(visit);

        Visit.builder().description("test").pet(pet1).build();
        ownerService.save(Owner.builder().address("test").city("test").firstName("test 1 builder").lastName("test 2").build());

    }

}
