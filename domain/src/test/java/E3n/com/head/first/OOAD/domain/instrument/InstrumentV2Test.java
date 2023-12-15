package E3n.com.head.first.OOAD.domain.instrument;

import E3n.com.head.first.OOAD.domain.v2.storeinstrument.enumerates.Builder;
import E3n.com.head.first.OOAD.domain.v2.storeinstrument.enumerates.Type;
import E3n.com.head.first.OOAD.domain.v2.storeinstrument.enumerates.TypeInstrument;
import E3n.com.head.first.OOAD.domain.v2.storeinstrument.enumerates.Wood;
import E3n.com.head.first.OOAD.domain.v2.storeinstrument.instrumentSpecs.InstrumentSpec;
import E3n.com.head.first.OOAD.domain.v2.storeinstrument.instruments.Instrument;
import E3n.com.head.first.OOAD.domain.v2.storeinstrument.inventory.Inventory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InstrumentV2Test {

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
        final var expectedInstrumentType = TypeInstrument.GUITAR;
        final var expectNumberStrings = 6;

        var instrumentSpec = new InstrumentSpec(expectedBuilder,
                expectedModel, expectedType, expectedBackwood,
                expectedFrontwood);

        instrumentSpec.setNumberString(6);

        final var instrument = new Instrument(expectedPrice,
                expectedSerialNumber, instrumentSpec, TypeInstrument.GUITAR);

        final var expectedSpec = instrument.getSpec();

        Assertions.assertNotNull(instrument);
        Assertions.assertEquals(expectedBackwood, expectedSpec.getBackwood());
        Assertions.assertEquals(expectedModel, expectedSpec.getModel());
        Assertions.assertEquals(expectedType, expectedSpec.getType());
        Assertions.assertEquals(expectedFrontwood, expectedSpec.getFrontwood());
        Assertions.assertEquals(expectedSerialNumber, instrument.getSerialNumber());
        Assertions.assertEquals(expectedPrice, instrument.getPrice());
        Assertions.assertEquals(expectedInstrumentType, instrument.getTypeInstrument());
        Assertions.assertEquals(expectNumberStrings, instrument.getSpec().getNumberString());

    }

    @Test
    public void whenSearchingForASpecThatExists_shouldFindListOfIt(){

        this.addingToInventory();
       final var expectedBuilder = Builder.FENDER;
       final var expectedModel = "stratocastor";
       final var expectedType = Type.ELECTRIC;
       final var expectedBackwood = Wood.ALDER;
       final var expectedFrontwood =  Wood.ALDER;
       final var expectedSerialNumber = "123456";
       final var expectedPrice = 1000.0;
       final var expectedInstrumentType = TypeInstrument.GUITAR;
       final var expectedMatches = 2;

       final var searchFor = new InstrumentSpec(Builder.FENDER, "stratocastor",
               Type.ELECTRIC, Wood.ALDER, Wood.ALDER);

       List<Instrument> instruments = this.inventory.search(searchFor);

       Assertions.assertEquals(expectedMatches, instruments.size());
       instruments.forEach(it ->{
           Assertions.assertNotNull(it);
           Assertions.assertEquals(expectedBackwood, it.getSpec().getBackwood());
           Assertions.assertEquals(expectedModel, it.getSpec().getModel());
           Assertions.assertEquals(expectedBuilder, it.getSpec().getBuilder());
           Assertions.assertEquals(expectedType, it.getSpec().getType());
           Assertions.assertEquals(expectedFrontwood, it.getSpec().getFrontwood());
           Assertions.assertEquals(expectedSerialNumber, it.getSerialNumber());
           Assertions.assertEquals(expectedPrice, it.getPrice());
           Assertions.assertEquals(expectedInstrumentType,
                   it.getTypeInstrument());
       });
    }

    @Test
    public void whenSearchingForASpecThatJustModelIsEqual_shouldFindAllInstrumentsWithSameModel(){

        this.addingToInventory();
        final var expectedBuilder = Builder.GIBSON;
        final var expectedModel = "stratocastor";
        final var expectedType = Type.ACOUSTIC;
        final var expectedBackwood = Wood.BRAZILIAN_ROSEWOOD;
        final var expectedFrontwood =  Wood.BRAZILIAN_ROSEWOOD;
        final var expectedMatches = 3;

        final var searchFor = new InstrumentSpec(expectedBuilder, expectedModel,
                expectedType, expectedBackwood, expectedFrontwood);

        List<Instrument> instruments = this.inventory.search(searchFor);

        Assertions.assertEquals(expectedMatches, instruments.size());
//        Assertions.assertNotNull(it);
//        Assertions.assertEquals(expectedBackwood, it.getSpec().getBackwood());
//        Assertions.assertEquals(expectedModel, it.getSpec().getModel());
//        Assertions.assertEquals(expectedBuilder, it.getSpec().getBuilder());
//        Assertions.assertEquals(expectedType, it.getSpec().getType());
//        Assertions.assertEquals(expectedFrontwood, it.getSpec().getFrontwood());
//        Assertions.assertEquals(expectedSerialNumber, it.getSerialNumber());
//        Assertions.assertEquals(expectedPrice, it.getPrice());
    }


    private void addingToInventory() {
        this.inventory = new Inventory();
        inventory.getInstruments().addAll(List.of(
                new Instrument(1000.0, "123456",
                        new InstrumentSpec(Builder.FENDER, "stratocastor",
                                Type.ELECTRIC, Wood.ALDER, Wood.ALDER),
                        TypeInstrument.GUITAR),

                new Instrument(1000.0, "123456",
                        new InstrumentSpec(Builder.FENDER, "stratocastor",
                                Type.ELECTRIC, Wood.ALDER, Wood.ALDER),
                        TypeInstrument.GUITAR),
                new Instrument(500, "123456",
                        new InstrumentSpec(Builder.FENDER, "mandolin",
                                Type.ELECTRIC, Wood.ALDER, Wood.ALDER),
                        TypeInstrument.MANDOLIN),

                new Instrument(800, "123456",
                        new InstrumentSpec(Builder.GIBSON, "mandolin",
                                Type.ACOUSTIC, Wood.ALDER, Wood.ALDER),
                        TypeInstrument.MANDOLIN),
                new Instrument(500, "123456",
                        new InstrumentSpec(Builder.FENDER, "bass",
                                Type.ELECTRIC, Wood.ALDER, Wood.ALDER),
                        TypeInstrument.BASS),
                new Instrument(500, "123456",
                        new InstrumentSpec(Builder.FENDER, "dobro",
                                Type.ELECTRIC, Wood.ALDER, Wood.ALDER),
                        TypeInstrument.DOBRO),
                new Instrument(500, "123456",
                        new InstrumentSpec(Builder.FENDER, "fiddle",
                                Type.ELECTRIC, Wood.ALDER, Wood.ALDER),
                        TypeInstrument.FIDDLE)
        ));
    }
}
