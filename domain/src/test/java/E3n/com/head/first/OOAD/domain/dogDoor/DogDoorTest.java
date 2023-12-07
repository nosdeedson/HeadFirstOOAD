package E3n.com.head.first.OOAD.domain.dogDoor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DogDoorTest {

    @Test
    public void whenCallingReconizer_shouldOpenedTheDoor() {
        final var barks = createBarks();
        final var expectedBark = new Bark("wolfiiii");
        final var door = new DogDoor();
        barks.forEach(door::addAllowedBark);
        final var reconizer = new BarkRecognizer(door);
        reconizer.recognize(expectedBark);
        Assertions.assertTrue(door.isOpened());

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Assertions.assertFalse(door.isOpened());
            }
        }, 11000);
    }

    @Test
    public void whenUsingRemoteControll_shouldOpenedTheDoor() {
        final var barks = createBarks();
        final var expectedBark = new Bark("wolfiiii");
        final var door = new DogDoor();
        barks.forEach(door::addAllowedBark);
        final var remoteControll = new RemoteControll(door);
        remoteControll.pressButton();
        Assertions.assertTrue(door.isOpened());

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Assertions.assertFalse(door.isOpened());
            }
        }, 11000);
    }

    private List<Bark> createBarks(){
        return List.of(
                new Bark("wolf"),
                new Bark("wolfiiii"),
                new Bark("woooolf"),
                new Bark("rooof")
        );
    }
}
