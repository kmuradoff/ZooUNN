package az.prompt.zoounn.ui.controller;

import az.prompt.zoounn.Cell;
import az.prompt.zoounn.Zoo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;


@Component
public class CellController implements Initializable {
    @Autowired
    private Zoo zoo;
    @FXML
    public Text cell_number;
    @FXML
    public Text herbivore_count;
    @FXML
    public Text predator_count;

    public void setCellsText(int i) {
        Cell cell = zoo.getCells().stream().filter(c -> c.getNumber() == i).findFirst().orElse(null);

        cell_number.setText(String.format("Cell %d", cell.getNumber()));
        herbivore_count.setText(String.format("Herbivores: %d", cell.countHerbivores()));
        predator_count.setText(String.format("Predators: %d", cell.countPredators()));
    }

    public int getCellsCount() {
        return zoo.getCells().size();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
