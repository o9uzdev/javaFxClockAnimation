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

    public String getTimeString(){
        // TO-DO
        return "";
    }

    void setCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        hour = now.getHour();
        minute = now.getMinute();
        second = now.getSecond();
        //paintClock();
    }
}
