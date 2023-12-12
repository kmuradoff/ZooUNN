package az.prompt.zoounn.ui.controller;

import az.prompt.zoounn.Cell;
import az.prompt.zoounn.Zoo;
import az.prompt.zoounn.animals.Deer;
import az.prompt.zoounn.animals.Lion;
import az.prompt.zoounn.animals.Rabbit;
import az.prompt.zoounn.animals.Tiger;
import az.prompt.zoounn.exceptions.BaseException;
import az.prompt.zoounn.service.DataBaseService;
import az.prompt.zoounn.service.ZooImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

@Component
@Slf4j
public class ZooController implements Initializable {
    @FXML
    public Button walk_in_zoo;
    @FXML
    public Button shop;
    @FXML
    public Text herbivore_count;
    @FXML
    public Text predator_count;
    @FXML
    public Text unique_animals;
    @Autowired
    private Zoo zoo = new ZooImpl();
    @Autowired
    private DataBaseService dataBaseService;
    private Stage stage = null;
    private Parent myNewScene = null;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        predator_count.setText(String.format("Predator count: %d", zoo.countPredators()));
        herbivore_count.setText(String.format("Herbivore count: %d", zoo.countPredators()));
        unique_animals.setText(String.format("Unique animals: %s", zoo.uniqueAnimalType()));


        walk_in_zoo.setOnAction(event -> {
            zoo.hearAnimals().forEach(System.out::println);
        });


        shop.setOnAction(actionEvent -> {
            stage = (Stage) shop.getScene().getWindow();
            try {
                myNewScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/shop.fxml")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Scene scene = new Scene(myNewScene);
            stage.setScene(scene);
            stage.setTitle("Zoo UNN Shop");
            stage.show();
        });
    }

    public void initZoo() {
        try {
            zoo.addCell(new Cell(0));
            zoo.addCell(new Cell(1));

            zoo.addAnimal(new Lion(), 0);
            zoo.addAnimal(new Lion(), 0);
            zoo.addAnimal(new Tiger(), 0);
            zoo.addAnimal(new Tiger(), 0);

            zoo.addAnimal(new Rabbit(), 1);
            zoo.addAnimal(new Deer(), 1);
            zoo.addAnimal(new Deer(), 1);
            zoo.addAnimal(new Rabbit(), 1);
        } catch (BaseException e) {
            throw new RuntimeException(e);
        }
        dataBaseService.save();
    }
}
