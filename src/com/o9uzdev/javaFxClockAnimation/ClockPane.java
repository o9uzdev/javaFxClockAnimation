package com.o9uzdev.javaFxClockAnimation;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
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
        return getHour()+":"+getMinute()+":"+getSecond();
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
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;

        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        Text t1 = new Text(centerX - 5, centerY - clockRadius + 15, "12");
        Text t2 = new Text(centerX - clockRadius + 5, centerY + 5, "9");
        Text t3 = new Text(centerX + clockRadius - 10, centerY + 5, "3");
        Text t4 = new Text(centerX - 5, centerY + clockRadius - 5, "6");
        Group textGroup = new Group();
        textGroup.getChildren().addAll(t1, t2, t3, t4);

        double secondLength = clockRadius * 0.8;
        double secondX = centerX + secondLength * Math.sin(second * 2 * Math.PI / 60.0);
        double secondY = centerY - secondLength * Math.cos(second * 2 * Math.PI / 60.0);
        Line secondLine = new Line(centerX, centerY, secondX, secondY);
        secondLine.setStroke(Color.GREEN);

        double minuteLength = clockRadius * 0.65;
        double minuteX = centerX + minuteLength * Math.sin(minute * 2 * Math.PI / 60.0);
        double minuteY = centerY - minuteLength * Math.cos(minute * 2 * Math.PI / 60.0);
        Line minuteLine = new Line(centerX, centerY, minuteX, minuteY);
        minuteLine.setStroke(Color.RED);
        minuteLine.setStrokeWidth(2);

        double hourLength = clockRadius * 0.5;
        double hourX = centerX + hourLength * Math.sin((hour % 12 + minute / 60.0) * 2 * Math.PI / 12.0);
        double hourY = centerY - hourLength * Math.cos((hour % 12 + minute / 60.0) * 2 * Math.PI / 12.0);
        Line hourLine = new Line(centerX, centerY, hourX, hourY);
        hourLine.setStroke(Color.BLUE);
        hourLine.setStrokeWidth(2);

        getChildren().clear();
        getChildren().addAll(circle, textGroup, secondLine, minuteLine, hourLine);
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
