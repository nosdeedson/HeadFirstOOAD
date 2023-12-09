package E3n.com.head.first.OOAD.domain.storeinstrument.enumerated;

import E3n.com.head.first.OOAD.domain.storeinstrument.instruments.*;
import E3n.com.head.first.OOAD.domain.storeinstrument.instrumentspec.*;

public enum WhoTune {
    BANJO {
        @Override
        public Instrument whoTune() {
            return new Banjo("123", 1000, new BanjoSpec(Builder.ANY, "banjo", Type.ACOUSTIC, Wood.ALDER, Wood.CEDAR), WhoTune.BANJO);
        }
    },
    BASS {
        @Override
        public Instrument whoTune() {
            return new Bass("123", 1000, new BassSpec(Builder.ANY, "bass", Type.ACOUSTIC, Wood.ALDER, Wood.CEDAR), WhoTune.BASS);
        }
    },
    DOBRO {
        @Override
        public Instrument whoTune() {
            return new Dobro("123", 1000, new DobroSpec(Builder.ANY, "dobro", Type.ACOUSTIC, Wood.ALDER, Wood.CEDAR), WhoTune.DOBRO);
        }
    },
    FIDDLE {
        @Override
        public Instrument whoTune() {
            return new Fiddle("123", 1000, new FiddleSpec(Builder.ANY, "fiddle", Type.ACOUSTIC, Wood.ALDER, Wood.CEDAR, "finisd"), WhoTune.FIDDLE);
        }
    },
    GUITAR {
        @Override
        public Instrument whoTune() {
            return new Guitar("123", 1000, new GuitarSpec(Builder.ANY, "guitar", Type.ACOUSTIC, Wood.ALDER, Wood.CEDAR), WhoTune.GUITAR);
        }
    },
    MANDOLIN {
        @Override
        public Instrument whoTune() {
            return new Mandolin("123", 1000, new MandolinSpec(Builder.ANY, "mandolin", Type.ACOUSTIC, Wood.ALDER, Wood.CEDAR, Style.A), WhoTune.MANDOLIN);
        }
    };

    public abstract Instrument whoTune();
}
