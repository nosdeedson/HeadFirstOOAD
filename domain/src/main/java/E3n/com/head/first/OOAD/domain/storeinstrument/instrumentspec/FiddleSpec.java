package E3n.com.head.first.OOAD.domain.storeinstrument.instrumentspec;

import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.Builder;
import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.Type;
import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.Wood;

import java.util.Objects;

public class FiddleSpec extends InstrumentSpec {

    private String finish;

    public FiddleSpec(Builder builder, String model, Type type, Wood backWood, Wood frontWood, String finish) {
        super(builder, model, type, backWood, frontWood);
        this.finish = finish;
    }

    public String getFinish() {
        return finish;
    }

    @Override
    public String toString() {
        return "FiddleSpec{" +
                "finish='" + finish + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FiddleSpec that = (FiddleSpec) o;
        return Objects.equals(finish, that.finish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), finish);
    }
}
