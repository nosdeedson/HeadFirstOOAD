package E3n.com.head.first.OOAD.domain.dogDoor;

import java.util.Objects;

public class Bark {

    private String sound;

    public Bark(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Bark bark = (Bark) o;
        return Objects.equals(getSound(), bark.getSound());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSound());
    }
}
