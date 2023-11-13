package az.prompt.zoounn.animals;

import az.prompt.zoounn.AnimalClassEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import static az.prompt.zoounn.AnimalClassEnum.PREDATOR;

@Getter
@Setter
@Slf4j
public class Animal {
    private String animalName;
    private AnimalClassEnum animalClass;
    private String animalType;

    public Animal(String animalName, AnimalClassEnum animalClass, String animalType) {
        this.animalName = animalName;
        this.animalClass = animalClass;
        this.animalType = animalType;
    }

    public String makeSound() {
        return "Animal with name " + animalName + " made a sound";
    }

    public boolean isPredator() {
        return animalClass == PREDATOR;
    }

}