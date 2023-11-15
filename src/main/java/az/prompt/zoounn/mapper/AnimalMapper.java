package az.prompt.zoounn.mapper;

import az.prompt.zoounn.animals.Animal;
import az.prompt.zoounn.model.AnimalJpa;
import az.prompt.zoounn.model.CellJpa;
import az.prompt.zoounn.repository.CellJpaRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class AnimalMapper {
    protected CellJpaRepository cellJpaRepository;

    @Autowired
    public void setCellJpaRepository(CellJpaRepository cellJpaRepository) {
        this.cellJpaRepository = cellJpaRepository;
    }

    public abstract AnimalJpa fromAnimal(Animal animal);

    @Mapping(target = "cellNumber", expression = "java(toCellNumber(animal))")
    public abstract Animal fromAnimalJpa(AnimalJpa animal);

    public CellJpa fromCellNumber(Animal animal) {
        return cellJpaRepository.findByNumber(animal.getCellNumber());
    }

    public int toCellNumber(AnimalJpa animalJpa) {
        return animalJpa.getCell().getNumber();
    }
}
