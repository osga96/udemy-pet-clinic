package com.ineo.learn.springframework.udemypetclinic.bootstrap;

import com.ineo.learn.springframework.udemypetclinic.modelPOJO.Owner;
import com.ineo.learn.springframework.udemypetclinic.modelPOJO.Vet;
import com.ineo.learn.springframework.udemypetclinic.services.OwnerService;
import com.ineo.learn.springframework.udemypetclinic.services.VetService;
import com.ineo.learn.springframework.udemypetclinic.services.map.OwnerServiceMap;
import com.ineo.learn.springframework.udemypetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public BootStrapData() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner("Persona 1", "Apellido1");
        Owner owner2 = new Owner("Persona 2", "Apellido2");
        Owner owner3 = new Owner("Persona 3", "Apellido3");

        ownerService.save(owner1);
        ownerService.save(owner2);
        ownerService.save(owner3);

        Vet vet1 = new Vet("Veterinario 1", "Apellido1");
        Vet vet2 = new Vet("Veterinario 2", "Apellido2");
        Vet vet3 = new Vet("Veterinario 3", "Apellido3");

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

    }

}
