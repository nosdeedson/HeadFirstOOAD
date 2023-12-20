package com.E3N.head.first.OOAD.domain.storeinstrument.instrumentspec;

import com.E3N.head.first.OOAD.domain.storeinstrument.enumerated.Builder;
import com.E3N.head.first.OOAD.domain.storeinstrument.enumerated.Type;
import com.E3N.head.first.OOAD.domain.storeinstrument.enumerated.Wood;

public class DobroSpec extends InstrumentSpec {
    public DobroSpec(Builder builder, String model, Type type, Wood backWood, Wood frontWood) {
        super(builder, model, type, backWood, frontWood);
    }


}
