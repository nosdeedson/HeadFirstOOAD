package E3N.com.designpatterns.bubblesorter.javadesignpatterns.abstractDocumentTest;

import E3N.com.designpatterns.javadesignpatterns.abstractDocument.Car;
import E3N.com.designpatterns.javadesignpatterns.abstractDocument.Property;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;


public class AbstractDocumentTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(AbstractDocumentTest.class);

    @Test
    public void instantiatingACar() {
        LOGGER.info("constructing parts and car");
        var wheelProperties = Map.of(
                Property.TYPE.toString(), "wheel",
                Property.MODEL.toString(), "15C",
                Property.PRICE.toString(), 100L
        );
        Assertions.assertNotNull(wheelProperties);
        Assertions.assertEquals(3, wheelProperties.size());

        var doorPropertie = Map.of(
                Property.TYPE.toString(), "door",
                Property.MODEL.toString(), "Lambo",
                Property.PRICE.toString(), 300L
        );
        Assertions.assertNotNull(doorPropertie);
        Assertions.assertEquals(3, wheelProperties.size());

        var carProperties = Map.of(
                Property.MODEL.toString(), "300SL",
                Property.PRICE.toString(), 10000L,
                Property.PARTS.toString(), List.of(wheelProperties, doorPropertie)
        );

        var car = new Car(carProperties);
        LOGGER.info("HERE IS OUR CAR");
        LOGGER.info("-> MODEL: {}", car.getModel());
        LOGGER.info("-> PRICE: {}", car.getPrice());
        LOGGER.info("-> Parts: ");
        car.getParts().forEach(part -> LOGGER.info("\t{}/{}/{}",
                part.getType().orElseThrow(),
                part.getModel().orElseThrow(),
                part.getPrice().orElseThrow()
        ));
        Assertions.assertNotNull(car.getParts());
        Assertions.assertEquals(2L, car.getParts().count());

    }
}
