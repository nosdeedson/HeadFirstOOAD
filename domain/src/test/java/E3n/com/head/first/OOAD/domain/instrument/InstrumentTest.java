package E3n.com.head.first.OOAD.domain.instrument;

import E3n.com.head.first.OOAD.domain.storeinstrument.*;
import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.*;
import E3n.com.head.first.OOAD.domain.storeinstrument.instruments.*;
import E3n.com.head.first.OOAD.domain.storeinstrument.instrumentspec.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InstrumentTest {

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

        final var spec = new GuitarSpec(expectedBuilder, expectedModel, expectedType, expectedBackwood, expectedFrontwood );

        final Instrument expectedGuitar = new Guitar(expectedSerialNumber, expectedPrice, spec, WhoTune.GUITAR);

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

        final var expectedSpec = new GuitarSpec(expectedBuilder, expectedModel, expectedType, expectedBackwood, expectedFrontwood);
        final var expectedSpec2 = new GuitarSpec(expectedBuilder, expectedModel, expectedType, expectedBackwood, expectedFrontwood);
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

        final var expectedSpec = new GuitarSpec(expectedBuilder, expectedModel, expectedType, expectedBackwood, expectedFrontwood);

        final var expectedSize = 2;

        final var matches = this.inventory.search(expectedSpec);
        Assertions.assertEquals(expectedSize, matches.size());
        matches.forEach( it -> {
            Assertions.assertEquals(it.getSpec(), expectedSpec);
            Assertions.assertEquals(expectedSerialNumber, it.getSerialNumber());
            Assertions.assertEquals(expectedPrice, it.getPrice());

        });
    }

    @Test
    public void whenSearchingForAMandolinSpecThatExists_shouldFindListOfIt() {
        addingToInventory();
        final var expectedBuilder = Builder.ANY;
        final var expectedModel = "mandolin";
        final var expectedType = Type.ACOUSTIC;
        final var expectedBackwood = Wood.BRAZILIAN_ROSEWOOD;
        final var expectedFrontwood = Wood.CEDAR;
        final var expectedSerialNumber = "1234";
        final var expectedPrice = 500.0;
        final var expectedStyle = Style.A;

        final var expectedSpec = new MandolinSpec(expectedBuilder, expectedModel, expectedType, expectedBackwood, expectedFrontwood, expectedStyle);

        final var expectedSize = 1;

        final var matches = this.inventory.search(expectedSpec);
        Assertions.assertEquals(expectedSize, matches.size());
        matches.forEach( it -> {
            Assertions.assertEquals(it.getSpec(), expectedSpec);
            Assertions.assertEquals(expectedSerialNumber, it.getSerialNumber());
            Assertions.assertEquals(expectedPrice, it.getPrice());

        });
    }

    @Test
    public void whenSearchingForABanjoSpecThatExists_shouldFindListOfIt() {
        addingToInventory();
        final var expectedBuilder = Builder.ANY;
        final var expectedModel = "banjo";
        final var expectedType = Type.ACOUSTIC;
        final var expectedBackwood = Wood.ALDER;
        final var expectedFrontwood = Wood.BRAZILIAN_ROSEWOOD;
        final var expectedSerialNumber = "122";
        final var expectedPrice = 300.0;

        final var expectedSpec = new BanjoSpec(expectedBuilder, expectedModel, expectedType, expectedBackwood, expectedFrontwood, 4);

        final var expectedSize = 1;

        final var matches = this.inventory.search(expectedSpec);
        Assertions.assertEquals(expectedSize, matches.size());
        matches.forEach( it -> {
            Assertions.assertEquals(it.getSpec(), expectedSpec);
            Assertions.assertEquals(expectedSerialNumber, it.getSerialNumber());
            Assertions.assertEquals(expectedPrice, it.getPrice());

        });
    }

    @Test
    public void whenSearchingForABassSpecThatExists_shouldFindListOfIt() {
        addingToInventory();
        final var expectedBuilder = Builder.FENDER;
        final var expectedModel = "bass";
        final var expectedType = Type.ACOUSTIC;
        final var expectedBackwood = Wood.ALDER;
        final var expectedFrontwood = Wood.BRAZILIAN_ROSEWOOD;
        final var expectedSerialNumber = "122";
        final var expectedPrice = 300.0;

        final var expectedSpec = new BassSpec(expectedBuilder, expectedModel, expectedType, expectedBackwood, expectedFrontwood, 4);

        final var expectedSize = 1;

        final var matches = this.inventory.search(expectedSpec);
        Assertions.assertEquals(expectedSize, matches.size());
        matches.forEach( it -> {
            Assertions.assertEquals(it.getSpec(), expectedSpec);
            Assertions.assertEquals(expectedSerialNumber, it.getSerialNumber());
            Assertions.assertEquals(expectedPrice, it.getPrice());
        });
    }

    @Test
    public void whenSearchingForAFiddleSpecThatExists_shouldFindListOfIt() {
        addingToInventory();
        final var expectedBuilder = Builder.ANY;
        final var expectedModel = "fiddle";
        final var expectedType = Type.ACOUSTIC;
        final var expectedBackwood = Wood.ALDER;
        final var expectedFrontwood = Wood.BRAZILIAN_ROSEWOOD;
        final var expectedSerialNumber = "122";
        final var expectedPrice = 300.0;

        final var expectedSpec = new FiddleSpec(expectedBuilder, expectedModel, expectedType, expectedBackwood, expectedFrontwood, "finish");

        final var expectedSize = 1;

        final var matches = this.inventory.search(expectedSpec);
        Assertions.assertEquals(expectedSize, matches.size());
        matches.forEach( it -> {
            Assertions.assertEquals(it.getSpec(), expectedSpec);
            Assertions.assertEquals(expectedSerialNumber, it.getSerialNumber());
            Assertions.assertEquals(expectedPrice, it.getPrice());
        });
    }

    @Test
    public void whenSearchingForADobroSpecThatExists_shouldFindListOfIt() {
        addingToInventory();
        final var expectedBuilder = Builder.ANY;
        final var expectedModel = "dobro";
        final var expectedType = Type.ACOUSTIC;
        final var expectedBackwood = Wood.ALDER;
        final var expectedFrontwood = Wood.BRAZILIAN_ROSEWOOD;
        final var expectedSerialNumber = "122";
        final var expectedPrice = 300.0;

        final var expectedSpec = new DobroSpec(expectedBuilder, expectedModel, expectedType, expectedBackwood, expectedFrontwood);

        final var expectedSize = 1;

        final var matches = this.inventory.search(expectedSpec);
        Assertions.assertEquals(expectedSize, matches.size());
        matches.forEach( it -> {
            Assertions.assertEquals(it.getSpec(), expectedSpec);
            Assertions.assertEquals(expectedSerialNumber, it.getSerialNumber());
            Assertions.assertEquals(expectedPrice, it.getPrice());

        });
    }

    private void addingToInventory() {
        this.inventory = new Inventory();
        inventory.getInventory().addAll(List.of(
                new Guitar("123", 1000.0,
                        new GuitarSpec(Builder.FENDER, "stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER), WhoTune.GUITAR),
                new Guitar("123",1000.0,
                        new GuitarSpec(Builder.FENDER, "stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER ), WhoTune.GUITAR),
                new Mandolin("1234", 500.0,
                        new MandolinSpec(Builder.ANY, "mandolin", Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.CEDAR, Style.A), WhoTune.MANDOLIN),
                new Banjo("122", 300,
                        new BanjoSpec(Builder.ANY, "banjo", Type.ACOUSTIC, Wood.ALDER, Wood.BRAZILIAN_ROSEWOOD, 4), WhoTune.BANJO),
                new Bass("122", 300,
                        new BassSpec(Builder.FENDER, "bass", Type.ACOUSTIC, Wood.ALDER, Wood.BRAZILIAN_ROSEWOOD), WhoTune.BASS),
                new Dobro("122", 300,
                        new DobroSpec(Builder.ANY, "dobro", Type.ACOUSTIC, Wood.ALDER, Wood.BRAZILIAN_ROSEWOOD), WhoTune.DOBRO),
                 new Fiddle("122", 300,
                         new FiddleSpec(Builder.ANY, "fiddle", Type.ACOUSTIC, Wood.ALDER, Wood.BRAZILIAN_ROSEWOOD, "finish"), WhoTune.FIDDLE)
        ));
    }

}