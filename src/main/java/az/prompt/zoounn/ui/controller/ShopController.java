package az.prompt.zoounn.ui.controller;

import az.prompt.zoounn.ZooUnnApplication;
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
    ZooUnnApplication zooUnnApplication;

    @Autowired
    CellController cellController;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        show_zoo.setOnAction(event -> {
/*            Stage stage = (Stage) show_zoo.getScene().getWindow();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/fxml/cell.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Zoo UNN");
            stage.show();*/

        });
    }
}
