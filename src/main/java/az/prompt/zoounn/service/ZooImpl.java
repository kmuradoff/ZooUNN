package az.prompt.zoounn.service;

import az.prompt.zoounn.Cell;
import az.prompt.zoounn.Zoo;
import az.prompt.zoounn.animals.Animal;
import az.prompt.zoounn.exceptions.BaseException;
import az.prompt.zoounn.repository.CellJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ZooImpl implements Zoo {

    private Set<Cell> cells = new HashSet<>();

    @Override
    public void addCell(Cell cell) throws BaseException {
        int cellNumber = cell.getNumber();

        Optional<Cell> cellWithSameNumber = cells.stream()
                .filter(c -> c.getNumber() == cellNumber)
                .findFirst();

        if (cellWithSameNumber.isPresent())
            throw new BaseException(String.format("Cell with %d already exists", cellNumber));

        cells.add(cell);
    }

    @Override
    public void addCells(Collection<Cell> cells) {
        this.cells = new HashSet<>(cells);
    }

    @Override
    public List<List<String>> hearAnimals() {
        return cells.stream()
                .map(Cell::hearAnimals)
                .collect(Collectors.toList());
    }

    @Override
    public long countHerbivores() {
        return cells.stream()
                .map(Cell::getAnimals)
                .flatMap(List::stream)
                .filter(animal -> !animal.isPredator())
                .count();
    }

    @Override
    public long countPredators() {
        return cells.stream()
                .map(Cell::getAnimals)
                .flatMap(List::stream)
                .filter(Animal::isPredator)
                .count();
    }

    @Override
    public List<String> uniqueAnimalType() {
        return cells.stream()
                .map(Cell::getAnimals)
                .flatMap(List::stream)
                .map(Animal::getAnimalType)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public void addAnimal(Animal animal, int cellNumber) throws BaseException {
        Cell cell = cells.stream()
                .filter(c -> c.getNumber() == cellNumber)
                .findFirst()
                .orElseThrow(() -> new BaseException(String.format("Cell with number %d not found", cellNumber)));

        cell.addAnimal(animal);
    }

    @Override
    public Set<Cell> getCells() {
        return cells;
    }
}
