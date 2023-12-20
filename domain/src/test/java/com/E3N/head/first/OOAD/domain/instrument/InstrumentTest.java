package com.E3N.head.first.OOAD.domain.instrument;

import com.E3N.head.first.OOAD.domain.storeinstrument.Inventory;
import com.E3N.head.first.OOAD.domain.storeinstrument.enumerated.*;
import com.E3N.head.first.OOAD.domain.storeinstrument.instruments.*;
import com.E3N.head.first.OOAD.domain.storeinstrument.instrumentspec.*;
import com.E3N.head.first.OOAD.domain.storeinstrument.tuner.Tuner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
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

        final Instrument expectedGuitar = new Guitar(expectedSerialNumber, expectedPrice, spec);

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

    @Test
    public void whenCallsToTuneInstruments_shouldTuneThem(){
        addingToInventory();
        List<String> instrumentsToTune = new ArrayList<>(this.inventory.getInventory().size());
        this.inventory.getInventory().forEach(it -> {
            instrumentsToTune.add( "afinando " + it.getClass().getSimpleName());
        });
        final int[] index = {0};
        this.inventory.getInventory().forEach((it) ->{
            final var tuner = new Tuner(it);
            Assertions.assertEquals(tuner.tunning(), instrumentsToTune.get(index[0]));
            index[0]++;
        });
    }

    private void addingToInventory() {
        this.inventory = new Inventory();
        inventory.getInventory().addAll(List.of(
                new Guitar("123", 1000.0,
                        new GuitarSpec(Builder.FENDER, "stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER)),
                new Guitar("123",1000.0,
                        new GuitarSpec(Builder.FENDER, "stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER )),
                new Mandolin("1234", 500.0,
                        new MandolinSpec(Builder.ANY, "mandolin", Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.CEDAR, Style.A)),
                new Banjo("122", 300,
                        new BanjoSpec(Builder.ANY, "banjo", Type.ACOUSTIC, Wood.ALDER, Wood.BRAZILIAN_ROSEWOOD, 4)),
                new Bass("122", 300,
                        new BassSpec(Builder.FENDER, "bass", Type.ACOUSTIC, Wood.ALDER, Wood.BRAZILIAN_ROSEWOOD)),
                new Dobro("122", 300,
                        new DobroSpec(Builder.ANY, "dobro", Type.ACOUSTIC, Wood.ALDER, Wood.BRAZILIAN_ROSEWOOD)),
                 new Fiddle("122", 300,
                         new FiddleSpec(Builder.ANY, "fiddle", Type.ACOUSTIC, Wood.ALDER, Wood.BRAZILIAN_ROSEWOOD, "finish"))
        ));
    }

}
