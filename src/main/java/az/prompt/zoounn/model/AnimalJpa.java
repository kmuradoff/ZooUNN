package az.prompt.zoounn.model;

import az.prompt.zoounn.AnimalClassEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "animal_jpa")
public class AnimalJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String animalName;


    @Enumerated(EnumType.STRING)
    private AnimalClassEnum animalClass;

    private String animalType;

    @ManyToOne
    private CellJpa cell;

}
