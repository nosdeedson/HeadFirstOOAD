package com.E3N.head.first.OOAD.domain.v2.storeinstrument.validator;

import com.E3N.head.first.OOAD.domain.v2.storeinstrument.enumerates.TypeInstrument;
import com.E3N.head.first.OOAD.domain.v2.storeinstrument.instruments.Instrument;

public class InstrumentValidator extends Validator{

    private Instrument instrument;

    public InstrumentValidator(ValidationHandler handler, Instrument instrument) {
        super(handler);
        this.instrument = instrument;
    }

    @Override
    public void validate() {
        if(( this.instrument.getTypeInstrument().equals(TypeInstrument.BANJO)
        || this.instrument.getTypeInstrument().equals(TypeInstrument.BASS)
                || this.instrument.getTypeInstrument().equals(TypeInstrument.GUITAR ))
                && this.instrument.getSpec().getNumberString() == null){
            final var error = new Error(("Number of string should be inform"));
            this.validationHandler().append(error);
        }
        if(this.instrument.getTypeInstrument().equals(TypeInstrument.FIDDLE)
        && this.instrument.getSpec().getFiddleFinish() == null){
            final var error = new Error(("'finish' should be inform"));
            this.validationHandler().append(error);
        }
        if(this.instrument.getTypeInstrument().equals(TypeInstrument.MANDOLIN)
                && this.instrument.getSpec().getMandolinStyle() == null){
            final var error = new Error(("'Style' should be inform"));
            this.validationHandler().append(error);
        }

    }
}
