package az.prompt.zoounn;

import az.prompt.zoounn.exceptions.BaseException;
import az.prompt.zoounn.service.DataBaseService;
import az.prompt.zoounn.ui.controller.CellController;
import az.prompt.zoounn.ui.controller.ZooController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ZooUnnApplication extends Application {

    @Autowired
    public CellController cellController;

    @Autowired
    private ZooController zooController;

    @Autowired
    private DataBaseService dataBaseService;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() throws BaseException {
        SpringApplication.run(getClass()).getAutowireCapableBeanFactory().autowireBean(this);
        //zooController.initZoo();
        dataBaseService.backup();
    }

    @Override
    public void start(Stage primaryStage) {
        Parent zooPane = loadFxml("/fxml/zoo.fxml", zooController);
        Pane root = (Pane) zooPane.lookup("#zooPane");

        HBox hbox = loadCells();
        root.getChildren().add(hbox);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        //dataBaseService.save();
    }

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
