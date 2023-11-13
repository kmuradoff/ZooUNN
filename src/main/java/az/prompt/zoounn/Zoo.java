package az.prompt.zoounn;

import az.prompt.zoounn.animals.Animal;
import az.prompt.zoounn.exceptions.BaseException;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface Zoo {
    void addCell(Cell cell) throws BaseException;
    void addCells(Collection<Cell> cells);

    List<List<String>> hearAnimals();

    void addAnimal(Animal animal, int cellNumber) throws BaseException;

    List<String> uniqueAnimalType();

    long countHerbivores();
    long countPredators();

    Set<Cell> getCells();
}
