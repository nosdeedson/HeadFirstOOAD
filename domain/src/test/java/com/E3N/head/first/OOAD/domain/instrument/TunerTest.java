package com.E3N.head.first.OOAD.domain.instrument;

import com.E3N.head.first.OOAD.domain.storeinstrument.enumerated.WhoTune;
import com.E3N.head.first.OOAD.domain.storeinstrument.instruments.*;
import com.E3N.head.first.OOAD.domain.storeinstrument.tuner.Tuner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TunerTest {

    @Test
    public void whenCreateAGuitar_shouldTuneIt(){
        final var expectedGuitar = new Guitar();
        final var whoTune = WhoTune.GUITAR;
        final var expectedInstrument = whoTune.whoTune();
        final var expectedTuner = new Tuner(expectedInstrument);
        final var expectedTuned = "afinando Guitar";

        final var result = expectedTuner.tunning();
        System.out.println(result);

        Assertions.assertNotNull(expectedInstrument);
        Assertions.assertEquals(expectedTuned, result);
        Assertions.assertEquals(expectedGuitar, expectedInstrument);
    }

    @Test
    public void whenCreateABanjo_shouldTuneIt(){
        final var expectedBanjo = new Banjo( );
        final var whoTune = WhoTune.BANJO;
        final var expectedInstrument = whoTune.whoTune();
        final var expectedTuner = new Tuner(expectedInstrument);
        final var expectedTuned = "afinando Banjo";

        final var result = expectedTuner.tunning();
        System.out.println(result);

        Assertions.assertNotNull(expectedInstrument);
        Assertions.assertEquals(expectedTuned, result);
        Assertions.assertEquals(expectedBanjo, expectedInstrument);

    }

    @Test
    public void whenCreateABass_shouldTuneIt(){
        final var expectedBass = new Bass( );
        final var whoTune = WhoTune.BASS;
        final var expectedInstrument = whoTune.whoTune();
        final var expectedTuner = new Tuner(expectedInstrument);
        final var expectedTuned = "afinando Bass";

        final var result = expectedTuner.tunning();
        System.out.println(result);

        Assertions.assertNotNull(expectedInstrument);
        Assertions.assertEquals(expectedTuned, result);
        Assertions.assertEquals(expectedBass, expectedInstrument);
    }

    @Test
    public void whenCreateADobro_shouldTuneIt(){
        final var expectedDobro = new Dobro( );
        final var whoTune = WhoTune.DOBRO;
        final var expectedInstrument = whoTune.whoTune();
        final var expectedTuner = new Tuner(expectedInstrument);
        final var expectedTuned = "afinando Dobro";

        final var result = expectedTuner.tunning();
        System.out.println(result);

        Assertions.assertNotNull(expectedInstrument);
        Assertions.assertEquals(expectedTuned, result);
        Assertions.assertEquals(expectedDobro, expectedInstrument);
    }

    @Test
    public void whenCreateAFiddle_shouldTuneIt(){
        final var expectedFiddle = new Fiddle( );
        final var whoTune = WhoTune.FIDDLE;
        final var expectedInstrument = whoTune.whoTune();
        final var expectedTuner = new Tuner(expectedInstrument);
        final var expectedTuned = "afinando Fiddle";

        final var result = expectedTuner.tunning();
        System.out.println(result);

        Assertions.assertNotNull(expectedInstrument);
        Assertions.assertEquals(expectedTuned, result);
        Assertions.assertEquals(expectedFiddle, expectedInstrument);
    }

    @Test
    public void whenCreateAMandolin_shouldTuneIt(){
        final var expectedMandolin = new Mandolin();
        final var whoTune = WhoTune.MANDOLIN;
        final var expectedInstrument = whoTune.whoTune();
        final var expectedTuner = new Tuner(expectedInstrument);
        final var expectedTuned = "afinando Mandolin";

        final var result = expectedTuner.tunning();
        System.out.println(result);

        Assertions.assertNotNull(expectedInstrument);
        Assertions.assertEquals(expectedTuned, result);
        Assertions.assertEquals(expectedMandolin, expectedInstrument);
    }
}
