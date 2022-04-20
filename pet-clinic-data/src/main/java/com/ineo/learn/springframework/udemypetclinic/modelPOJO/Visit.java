package com.ineo.learn.springframework.udemypetclinic.modelPOJO;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    @Column(name = "date")
    public LocalDate date;

    @Column(name = "description")
    public String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    public Pet pet;

}
