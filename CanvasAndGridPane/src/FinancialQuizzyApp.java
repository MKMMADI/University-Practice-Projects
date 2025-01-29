

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FinancialQuizzyApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Menu Bar
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu helpMenu = new Menu("Help");
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        // Left Panel
        VBox leftPanel = new VBox();
        TitledPane importDataPane = new TitledPane("Import Data", new ListView<>());
        TitledPane listPerformancePane = new TitledPane("List Performance", new ListView<>());
        TitledPane analyzeDataPane = new TitledPane("Analyze Data", new ListView<>());
        leftPanel.getChildren().addAll(importDataPane, listPerformancePane, analyzeDataPane);

        // Right Panel - FinancialQuizzyCanvas
         GridPane GP = new GridPane();
         
        // Add columns and data to the tableView as needed

        // Layout
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setLeft(leftPanel);
        borderPane.setCenter(new Canvas());

        // Scene
        Scene scene = new Scene(borderPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("FinancialQuizzyApp");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

