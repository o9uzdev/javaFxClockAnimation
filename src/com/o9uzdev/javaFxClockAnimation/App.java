package com.o9uzdev.javaFxClockAnimation;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ClockPane clock = new ClockPane();
        Label lblTime = new Label();
        lblTime.setFont(new Font(14));
        EventHandler<ActionEvent> handler = e -> {
            clock.setCurrentTime();
            lblTime.setText(clock.getTimeString());
        };

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), handler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        BorderPane root = new BorderPane();
        root.setCenter(clock);
        root.setBottom(lblTime);
        BorderPane.setAlignment(lblTime, Pos.TOP_CENTER);
        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.setTitle("Clock Animation");
        stage.show();
    }
}
