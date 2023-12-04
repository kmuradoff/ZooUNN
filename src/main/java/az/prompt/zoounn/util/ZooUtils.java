package az.prompt.zoounn.util;

import az.prompt.zoounn.ui.controller.CellController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ZooUtils {

    @Autowired
    private CellController cellController = new CellController();


    public Parent loadFxml(String view, Object controller) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(view));
        loader.setControllerFactory(param -> controller);
        try {
            loader.load();
        } catch (IOException ex) {
            System.err.println("IOException while loading resource " + view);
        }
        return loader.getRoot();
    }

    public HBox loadCells() {
        HBox hbox = new HBox();
        for (int i = 0; i < cellController.getCellsCount(); i++) {
            Parent cellPane = loadFxml("/fxml/cell.fxml", cellController);
            hbox.getChildren().add(cellPane);
            cellController.setCellsText(i);
        }
        return hbox;
    }
}
