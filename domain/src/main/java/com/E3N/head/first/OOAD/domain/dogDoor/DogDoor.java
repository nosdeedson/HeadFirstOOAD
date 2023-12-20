package com.E3N.head.first.OOAD.domain.dogDoor;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {

    private boolean opened;

    private List<Bark> allowedBarks;

    public DogDoor() {
        this.opened = false;
        this.allowedBarks = new ArrayList<>();
    }

    public void addAllowedBark(final Bark bark){
        this.allowedBarks.add(bark);
    }

    public void open() {
        this.opened = true;
        final Timer timer = new Timer();
        System.out.println("opened");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                close();
                timer.cancel();
            }
        }, 10000);
        System.out.println("closed");
    }

    public void close() {
        this.opened = false;
    }

    public boolean isOpened() {
        return opened;
    }

    public List<Bark> getAllowedBarks() {
        return allowedBarks;
    }
}
