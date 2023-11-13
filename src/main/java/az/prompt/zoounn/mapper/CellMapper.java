package az.prompt.zoounn.mapper;

import az.prompt.zoounn.Cell;
import az.prompt.zoounn.animals.Animal;
import az.prompt.zoounn.model.AnimalJpa;
import az.prompt.zoounn.model.CellJpa;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
@RequiredArgsConstructor
public abstract class CellMapper {

    protected AnimalMapper animalMapper;

    @Autowired
    public void setAnimalMapper(AnimalMapper animalMapper) {
        this.animalMapper = animalMapper;
    }

    @Mapping(target = "animals", expression = "java(toAnimalsJpa(cell))")
    public abstract CellJpa fromCell(Cell cell);

    @Mapping(target = "animals", expression = "java(toAnimals(cell))")
    public abstract Cell fromCellJpa(CellJpa cell);

    protected List<Animal> toAnimals(CellJpa cellJpa) {
        List<Animal> animals = new ArrayList<>();

        for (AnimalJpa animalJpa : cellJpa.getAnimals())
            animals.add(animalMapper.fromAnimalJpa(animalJpa));

        return animals;
    }

    protected List<AnimalJpa> toAnimalsJpa(Cell cell) {
        List<AnimalJpa> animals = new ArrayList<>();

        for (Animal animalJpa : cell.getAnimals())
            animals.add(animalMapper.fromAnimal(animalJpa));

        return animals;
    }
}
