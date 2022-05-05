package com.ineo.learn.springframework.udemypetclinic.modelPOJO;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate date;

    @Column(name = "description")
    public String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    public Pet pet;

}
