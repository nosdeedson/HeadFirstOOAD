package com.E3N.head.first.OOAD.domain.dogDoor;

public class RemoteControll {

    private final DogDoor dogDoor;

    public RemoteControll(DogDoor dogDoor) {
        this.dogDoor = dogDoor;
    }

    public void pressButton(){
        this.dogDoor.open();
    }
}
