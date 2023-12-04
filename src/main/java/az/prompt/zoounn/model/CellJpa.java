package az.prompt.zoounn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@Setter
@Entity
@Table(name = "cell_jpa")
public class CellJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int number;

    @OneToMany(mappedBy = "cell", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AnimalJpa> animals = new ArrayList<>();
}
