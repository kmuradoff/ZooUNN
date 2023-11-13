package az.prompt.zoounn;

import az.prompt.zoounn.animals.Animal;
import az.prompt.zoounn.exceptions.BaseException;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Slf4j
public class Cell {
    private static final int MAX_SIZE = 4;

    private int number;
    private List<Animal> animals = new ArrayList<>(MAX_SIZE);

    public void addAnimal(Animal animal) throws BaseException {
        if (animals.size() >= MAX_SIZE)
            throw new BaseException("Cell is full");

        boolean differentType = animals.stream().anyMatch(a -> a.isPredator() != animal.isPredator());
        if (differentType)
            throw new BaseException("You cannot add predator to the cage with herbivores and vice versa");

        animals.add(animal);
    }

    public List<String> hearAnimals() {
        List<String> sounds = new ArrayList<>();
        for (Animal animal : animals)
            sounds.add(animal.makeSound());
        return sounds;
    }

    public Cell(int number) {
        this.number = number;
    }

    public long countHerbivores() {
        return animals.stream().filter(animal -> !animal.isPredator()).count();
    }

    public long countPredators() {
        return animals.stream().filter(Animal::isPredator).count();
    }
}
