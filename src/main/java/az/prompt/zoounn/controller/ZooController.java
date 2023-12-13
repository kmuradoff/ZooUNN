package az.prompt.zoounn.controller;

import az.prompt.zoounn.Cell;
import az.prompt.zoounn.Zoo;
import az.prompt.zoounn.animals.*;
import az.prompt.zoounn.exceptions.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/zoo")
public class ZooController {
    private final Zoo zoo;

    @PostMapping("/add/cell")
    public ResponseEntity<?> addCell(Cell cell) throws BaseException {
        zoo.addCell(cell);
        return ResponseEntity.ok().body("Cell added successfully");
    }

    @PostMapping("/add/cells")
    public ResponseEntity<?> addCells(Collection<Cell> cells) {
        zoo.addCells(cells);
        return ResponseEntity.ok().body("Cells added successfully");
    }

    @GetMapping("/get/hear-animals")
    public ResponseEntity<List<List<String>>> hearAnimals() {
        return ResponseEntity.ok(zoo.hearAnimals());
    }

    @PostMapping("/add/animal/deer")
    public ResponseEntity<?> addAnimalDeer(int cellNumber) throws BaseException {
        Deer deer = new Deer();
        zoo.addAnimal(deer, cellNumber);
        return ResponseEntity.ok().body("Animal added successfully");
    }

    @PostMapping("/add/animal/lion")
    public ResponseEntity<?> addAnimalLion(int cellNumber) throws BaseException {
        Lion lion = new Lion();
        zoo.addAnimal(lion, cellNumber);
        return ResponseEntity.ok().body("Animal added successfully");
    }

    @PostMapping("/add/animal/rabbit")
    public ResponseEntity<?> addAnimalRabbit(int cellNumber) throws BaseException {
        Rabbit rabbit = new Rabbit();
        zoo.addAnimal(rabbit, cellNumber);
        return ResponseEntity.ok().body("Animal added successfully");
    }

    @PostMapping("/add/animal/tiger")
    public ResponseEntity<?> addAnimalTiger(int cellNumber) throws BaseException {
        Tiger tiger = new Tiger();
        zoo.addAnimal(tiger, cellNumber);
        return ResponseEntity.ok().body("Animal added successfully");
    }

    @GetMapping("/get/unique-animal-type")
    public ResponseEntity<List<String>> getUniqueAnimalType() {
        return ResponseEntity.ok(zoo.uniqueAnimalType());
    }

    @GetMapping("/get/herbivores-count")
    public ResponseEntity<?> getHerbivoresCount() {
        return ResponseEntity.ok("There are " + zoo.countHerbivores() + " herbivores in the Zoo");
    }

    @GetMapping("/get/predators-count")
    public ResponseEntity<?> getPredatorsCount() {
        return ResponseEntity.ok("There are " + zoo.countPredators() + " predators in the Zoo");
    }

    @GetMapping("/get/cells")
    public ResponseEntity<Set<Cell>> getCells() {
        return ResponseEntity.ok(zoo.getCells());
    }
}
