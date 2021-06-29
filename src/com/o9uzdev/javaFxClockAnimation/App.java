package com.o9uzdev.javaFxClockAnimation;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Label lblTime = new Label();
        lblTime.setFont(new Font(14));

        BorderPane root = new BorderPane();
        root.setBottom(lblTime);
        BorderPane.setAlignment(lblTime, Pos.TOP_CENTER);

        Scene scene = new Scene(root,300,300);
        stage.setScene(scene);
        stage.setTitle("Clock Animation");
        stage.show();
    }
}
