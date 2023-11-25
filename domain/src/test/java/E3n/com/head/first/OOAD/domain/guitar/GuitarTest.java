package E3n.com.head.first.OOAD.domain.guitar;

import E3n.com.head.first.OOAD.Fixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GuitarTest {

    private Inventory inventory;

    @Test
    public void whenCreateGuitar_shouldCreateIt() {
        final var expectedBuilder = Builder.FENDER;
        final var expectedModel = "stratocastor";
        final var expectedType = Type.ELECTRIC;
        final var expectedBackwood = Wood.ALDER;
        final var expectedFrontwood = Wood.ALDER;
        final var expectedSerialNumber = "123";
        final var expectedPrice = 1000.0;

        final var spec = new GuitarSpec()
                .withBuilder(expectedBuilder)
                .withModel(expectedModel)
                .withType(expectedType)
                .withBackWood(expectedBackwood)
                .withFrontWood(expectedFrontwood);

        final var expectedGuitar = new Guitar()
                .withSerialNumber(expectedSerialNumber)
                .withPrice(expectedPrice)
                .withSpec(spec);

        final var expectedSpec = expectedGuitar.getSpec();

        Assertions.assertNotNull(expectedGuitar);
        Assertions.assertEquals(expectedBackwood, expectedSpec.getBackWood());
        Assertions.assertEquals(expectedModel, expectedSpec.getModel());
        Assertions.assertEquals(expectedType, expectedSpec.getType());
        Assertions.assertEquals(expectedFrontwood, expectedSpec.getFrontWood());
        Assertions.assertEquals(expectedSerialNumber, expectedGuitar.getSerialNumber());
        Assertions.assertEquals(expectedPrice, expectedGuitar.getPrice());

    }

    @Test
    public void whenCreateTwoEqualsGuitarSpec_shouldBeEquals(){
        final var expectedBuilder = Builder.FENDER;
        final var expectedModel = "stratocastor";
        final var expectedType = Type.ELECTRIC;
        final var expectedBackwood = Wood.ALDER;
        final var expectedFrontwood = Wood.ALDER;

        final var expectedSpec = new GuitarSpec()
                .withBuilder(expectedBuilder)
                .withModel(expectedModel)
                .withType(expectedType)
                .withBackWood(expectedBackwood)
                .withFrontWood(expectedFrontwood);


        final var expectedSpec2 = new GuitarSpec()
                .withBuilder(expectedBuilder)
                .withModel(expectedModel)
                .withType(expectedType)
                .withBackWood(expectedBackwood)
                .withFrontWood(expectedFrontwood);
        Assertions.assertEquals(expectedSpec, expectedSpec2);

    }

    @Test
    public void whenSearchingForAGuitarSpecThatExists_shouldFindListOfIt() {
        addingToInventory();

        final var expectedBuilder = Builder.FENDER;
        final var expectedModel = "stratocastor";
        final var expectedType = Type.ELECTRIC;
        final var expectedBackwood = Wood.ALDER;
        final var expectedFrontwood = Wood.ALDER;
        final var expectedSerialNumber = "123";
        final var expectedPrice = 1000.0;

        final var expectedSpec = new GuitarSpec()
                .withBackWood(expectedBackwood)
                .withBuilder(expectedBuilder)
                .withModel(expectedModel)
                .withFrontWood(expectedFrontwood)
                .withType(expectedType);

        final var expectedSize = 2;


        final var matches = this.inventory.search(this.inventory.getGuitars(), expectedSpec);
        Assertions.assertEquals(expectedSize, matches.size());
        matches.forEach( it -> {
            Assertions.assertEquals(it.getSpec(), expectedSpec);
            Assertions.assertEquals(expectedSerialNumber, it.getSerialNumber());
            Assertions.assertEquals(expectedPrice, it.getPrice());

        });
    }

    private void addingToInventory() {
        this.inventory = new Inventory();
        inventory.getGuitars().addAll(List.of(
                new Guitar()
                        .withSerialNumber("123")
                        .withPrice(1000.0)
                        .withSpec(new GuitarSpec()
                                .withBuilder(Builder.FENDER)
                                .withModel("stratocastor")
                                .withType(Type.ELECTRIC)
                                .withBackWood(Wood.ALDER)
                                .withFrontWood(Wood.ALDER)),
                new Guitar()
                .withSerialNumber("123")
                .withPrice(1000.0)
                .withSpec(new GuitarSpec()
                        .withBuilder(Builder.FENDER)
                        .withModel("stratocastor")
                        .withType(Type.ELECTRIC)
                        .withBackWood(Wood.ALDER)
                        .withFrontWood(Wood.ALDER))
        ));

    }

}
