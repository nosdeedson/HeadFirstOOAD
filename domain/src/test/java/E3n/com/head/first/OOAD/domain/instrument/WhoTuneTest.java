package E3n.com.head.first.OOAD.domain.instrument;

import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.*;
import E3n.com.head.first.OOAD.domain.storeinstrument.instruments.*;
import E3n.com.head.first.OOAD.domain.storeinstrument.instrumentspec.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WhoTuneTest {

    @Test
    public void whenCreateAGuitar_shouldTuneIt(){

        final var expectedTuner = WhoTune.GUITAR;
        final var spec = new GuitarSpec(Builder.FENDER, "expectedModel", Type.ACOUSTIC, Wood.ALDER, Wood.CEDAR );
        final Instrument expectedInstrument = new Guitar("123", 1000, spec, expectedTuner);
        final var expectedTuned = "afinando " + expectedInstrument.getClass().getSimpleName();

        final var result = expectedInstrument.tune();
        System.out.println(result);

        Assertions.assertNotNull(expectedInstrument);
        Assertions.assertEquals(expectedTuned, result);
    }

    @Test
    public void whenCreateABanjo_shouldTuneIt(){
        final var expectedTuner = WhoTune.BANJO;
        final var spec = new BanjoSpec(Builder.FENDER, "expectedModel", Type.ACOUSTIC, Wood.ALDER, Wood.CEDAR );
        final Instrument expectedInstrument = new Banjo("123", 1000, spec, expectedTuner);
        final var expectedTuned = "afinando " + expectedInstrument.getClass().getSimpleName();

        final var result = expectedInstrument.tune();
        System.out.println(result);

        Assertions.assertNotNull(expectedInstrument);
        Assertions.assertEquals(expectedTuned, result);
    }

    @Test
    public void whenCreateABass_shouldTuneIt(){
        final var expectedTuner = WhoTune.BASS;
        final var spec = new BassSpec(Builder.FENDER, "expectedModel", Type.ACOUSTIC, Wood.ALDER, Wood.CEDAR );
        final Instrument expectedInstrument = new Bass("123", 1000, spec, expectedTuner);
        final var expectedTuned = "afinando " + expectedInstrument.getClass().getSimpleName();

        final var result = expectedInstrument.tune();
        System.out.println(result);

        Assertions.assertNotNull(expectedInstrument);
        Assertions.assertEquals(expectedTuned, result);
    }

    @Test
    public void whenCreateADobro_shouldTuneIt(){
        final var expectedTuner = WhoTune.DOBRO;
        final var spec = new DobroSpec(Builder.FENDER, "expectedModel", Type.ACOUSTIC, Wood.ALDER, Wood.CEDAR );
        final Instrument expectedInstrument = new Dobro("123", 1000, spec, expectedTuner);
        final var expectedTuned = "afinando " + expectedInstrument.getClass().getSimpleName();

        final var result = expectedInstrument.tune();
        System.out.println(result);

        Assertions.assertNotNull(expectedInstrument);
        Assertions.assertEquals(expectedTuned, result);
    }

    @Test
    public void whenCreateAFiddle_shouldTuneIt(){
        final var expectedTuner = WhoTune.FIDDLE;
        final var spec = new FiddleSpec(Builder.FENDER, "expectedModel", Type.ACOUSTIC, Wood.ALDER, Wood.CEDAR, "finish" );
        final Instrument expectedInstrument = new Fiddle("123", 1000, spec, expectedTuner);
        final var expectedTuned = "afinando " + expectedInstrument.getClass().getSimpleName();

        final var result = expectedInstrument.tune();
        System.out.println(result);

        Assertions.assertNotNull(expectedInstrument);
        Assertions.assertEquals(expectedTuned, result);
    }

    @Test
    public void whenCreateAMandolin_shouldTuneIt(){
        final var expectedTuner = WhoTune.MANDOLIN;
        final var spec = new MandolinSpec(Builder.FENDER, "expectedModel", Type.ACOUSTIC, Wood.ALDER, Wood.CEDAR, Style.A );
        final Instrument expectedInstrument = new Mandolin("123", 1000, spec, expectedTuner);
        final var expectedTuned = "afinando " + expectedInstrument.getClass().getSimpleName();

        final var result = expectedInstrument.tune();
        System.out.println(result);

        Assertions.assertNotNull(expectedInstrument);
        Assertions.assertEquals(expectedTuned, result);
    }

}
