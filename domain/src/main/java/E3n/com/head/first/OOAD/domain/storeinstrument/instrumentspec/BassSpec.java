package E3n.com.head.first.OOAD.domain.storeinstrument.instrumentspec;

import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.Builder;
import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.Type;
import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.Wood;

import java.util.Objects;

public class BassSpec extends InstrumentSpec {

    private Integer numberStrings;

    public BassSpec(Builder builder, String model, Type type, Wood backWood, Wood frontWood) {
        super(builder, model, type, backWood, frontWood);
        this.numberStrings = 4;
    }

    public BassSpec(Builder builder, String model, Type type, Wood backWood, Wood frontWood, Integer numberStrings) {
        super(builder, model, type, backWood, frontWood);
        this.numberStrings = numberStrings;
    }

    public Integer getNumberStrings() {
        return numberStrings;
    }

    @Override
    public String toString() {
        return "BassSpec{" +
                "numberStrings=" + numberStrings +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BassSpec bassSpec = (BassSpec) o;
        return Objects.equals(numberStrings, bassSpec.numberStrings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberStrings);
    }
}
