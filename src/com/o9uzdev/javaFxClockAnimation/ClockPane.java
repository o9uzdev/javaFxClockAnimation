package com.o9uzdev.javaFxClockAnimation;

import javafx.scene.layout.Pane;

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
