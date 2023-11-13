package az.prompt.zoounn.mapper;

import az.prompt.zoounn.animals.Animal;
import az.prompt.zoounn.model.AnimalJpa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnimalMapper {
    AnimalJpa fromAnimal(Animal animal);

    Animal fromAnimalJpa(AnimalJpa animal);
}
