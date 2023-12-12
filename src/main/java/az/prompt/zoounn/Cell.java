package az.prompt.zoounn;

import az.prompt.zoounn.animals.Animal;
import az.prompt.zoounn.exceptions.BaseException;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Slf4j
public class Cell implements Serializable {
    private static final int MAX_SIZE = 4;

    private long id;
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
        return animals.stream()
                .map(Animal::makeSound)
                .collect(Collectors.toList());

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
