package com.E3N.head.first.OOAD.domain.storeinstrument.instrumentspec;

import com.E3N.head.first.OOAD.domain.storeinstrument.enumerated.Builder;
import com.E3N.head.first.OOAD.domain.storeinstrument.enumerated.Style;
import com.E3N.head.first.OOAD.domain.storeinstrument.enumerated.Type;
import com.E3N.head.first.OOAD.domain.storeinstrument.enumerated.Wood;

import java.util.Objects;

public class MandolinSpec extends InstrumentSpec {

    private Style style;

    public MandolinSpec(Builder builder, String model, Type type, Wood backWood, Wood frontWood, Style style) {
        super(builder, model, type, backWood, frontWood);
        this.style = style;
    }

    public Style getStyle() {
        return style;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MandolinSpec that = (MandolinSpec) o;
        return style == that.style;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), style);
    }
}
