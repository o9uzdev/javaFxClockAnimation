package com.o9uzdev.javaFxClockAnimation;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.time.LocalDateTime;

public class ClockPane extends Pane {
    private int hour;
    private int minute;
    private int second;

    public ClockPane() {
        setCurrentTime();
    }

    public ClockPane(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
        paintClock();
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
        paintClock();
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
        paintClock();
    }

    public String getTimeString() {
        // TO-DO
        return "";
    }

    void setCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        hour = now.getHour();
        minute = now.getMinute();
        second = now.getSecond();
        paintClock();
    }

    private void paintClock() {
        double clockRadius = Math.min(getHeight(), getWidth()) * 0.5 * 0.8;
        double centerX = getWidth()/2;
        double centerY = getHeight()/2;

        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        Text t1 = new Text(centerX-5, centerY-clockRadius+15, "12");
        Text t2 = new Text(centerX - clockRadius + 5, centerY + 5, "9");
        Text t3 = new Text(centerX + clockRadius - 10, centerY + 5, "3");
        Text t4 = new Text(centerX-5, centerY+clockRadius - 5, "6");
        Group textGroup = new Group();
        textGroup.getChildren().addAll(t1,t2,t3,t4);
    }

    @Override
    protected void setWidth(double value) {
        super.setWidth(value);
        paintClock();
    }

    @Override
    protected void setHeight(double value) {
        super.setHeight(value);
        paintClock();
    }
}
