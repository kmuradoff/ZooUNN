package az.prompt.zoounn.ui.controller;

import az.prompt.zoounn.ZooUnnApplication;
import az.prompt.zoounn.service.DataBaseService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ShopController implements Initializable {

    @FXML
    Button buy_cell;

    @FXML
    Button show_zoo;

    @FXML
    Button cage_animal;

    @Autowired
    DataBaseService dataBaseService;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        show_zoo.setOnAction(event -> {
        });

        cage_animal.setOnAction(actionEvent -> {
            //todo
            dataBaseService.save();
        });

        buy_cell.setOnAction(actionEvent -> {
            //todo
            dataBaseService.save();
        });
    }
}
