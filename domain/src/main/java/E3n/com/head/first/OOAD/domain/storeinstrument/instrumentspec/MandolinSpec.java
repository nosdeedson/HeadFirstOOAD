package E3n.com.head.first.OOAD.domain.storeinstrument.instrumentspec;

import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.Builder;
import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.Style;
import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.Type;
import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.Wood;

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
