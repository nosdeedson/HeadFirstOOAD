package com.E3N.head.first.OOAD.domain.dogDoor;

public class BarkRecognizer {

    private DogDoor door;

    public BarkRecognizer(DogDoor door) {
        this.door = door;
    }

    public void recognize(final Bark bark){
        for (Bark b: door.getAllowedBarks()){
           if (b.equals(bark)){
               this.door.open();
               break;
           }
        }
    }
}
