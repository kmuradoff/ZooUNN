package az.prompt.zoounn.animals;

import az.prompt.zoounn.AnimalClassEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Getter
@Setter
@Slf4j
public class Animal implements Serializable {
    private String animalName;
    private AnimalClassEnum animalClass;
    private String animalType;
    private int cellNumber;

    public Animal(String animalName, AnimalClassEnum animalClass, String animalType) {
        this.animalName = animalName;
        this.animalClass = animalClass;
        this.animalType = animalType;
    }

    public String makeSound() {
        return "Animal with name " + animalName + " made a sound";
    }

    public boolean isPredator() {
        return animalClass == AnimalClassEnum.PREDATOR;
    }
}
