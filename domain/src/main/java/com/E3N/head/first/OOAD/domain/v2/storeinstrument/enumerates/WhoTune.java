package com.E3N.head.first.OOAD.domain.v2.storeinstrument.enumerates;

import com.E3N.head.first.OOAD.domain.storeinstrument.instruments.*;

public enum WhoTune {
    BANJO {
        @Override
        public Instrument whoTune() {
            return new Banjo();
        }
    },
    BASS {
        @Override
        public Instrument whoTune() {
            return new Bass();
        }
    },
    DOBRO {
        @Override
        public Instrument whoTune() {
            return new Dobro( );
        }
    },
    FIDDLE {
        @Override
        public Instrument whoTune() {
            return new Fiddle( );
        }
    },
    GUITAR {
        @Override
        public Instrument whoTune() {
            return new Guitar( );
        }
    },
    MANDOLIN {
        @Override
        public Instrument whoTune() {
            return new Mandolin();
        }
    };

    public abstract Instrument whoTune();
}
