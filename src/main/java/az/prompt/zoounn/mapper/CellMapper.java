package az.prompt.zoounn.mapper;

import az.prompt.zoounn.Cell;
import az.prompt.zoounn.animals.Animal;
import az.prompt.zoounn.model.AnimalJpa;
import az.prompt.zoounn.model.CellJpa;
import az.prompt.zoounn.repository.CellJpaRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@RequiredArgsConstructor
public abstract class CellMapper {
    protected AnimalMapper animalMapper;
    protected CellJpaRepository cellJpaRepository;

    @Autowired
    public void setCellJpaRepository(CellJpaRepository cellJpaRepository) {
        this.cellJpaRepository = cellJpaRepository;
    }

    @Autowired
    public void setAnimalMapper(AnimalMapper animalMapper) {
        this.animalMapper = animalMapper;
    }

    public abstract CellJpa fromCell(Cell cell);

    @Mapping(target = "animals", expression = "java(toAnimals(cell))")
    public abstract Cell fromCellJpa(CellJpa cell);

    protected List<Animal> toAnimals(CellJpa cellJpa) {
        List<Animal> animals = new ArrayList<>();

        for (AnimalJpa animalJpa : cellJpa.getAnimals()) {
            Animal animal = animalMapper.fromAnimalJpa(animalJpa);
            animal.setCellNumber(cellJpa.getNumber());

            animals.add(animal);
        }

        return animals;
    }

    protected List<AnimalJpa> toAnimalsJpa(Cell cell) {
        CellJpa cellJpa = cellJpaRepository.findByNumber(cell.getNumber());
        List<AnimalJpa> animals = new ArrayList<>();

        for (Animal animal : cell.getAnimals()) {
            AnimalJpa animalJpa = animalMapper.fromAnimal(animal);
            animalJpa.setCell(cellJpa);

            animals.add(animalJpa);
        }

        return animals;
    }
}
