package E3n.com.head.first.OOAD.domain.storeinstrument.instrumentspec;

import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.Builder;
import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.Type;
import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.Wood;

import java.util.Objects;

public abstract class InstrumentSpec {
    private Builder builder;
    private String model;
    private Type type;
    private Wood backWood;
    private Wood frontWood;

    public InstrumentSpec() {
    }

    public InstrumentSpec(Builder builder, String model, Type type, Wood backWood, Wood frontWood) {
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.frontWood = frontWood;
    }

    public InstrumentSpec setBuilder(Builder builder) {
        this.builder = builder;
        return this;
    }

    public InstrumentSpec setModel(String model) {
        this.model = model;
        return this;
    }

    public InstrumentSpec setType(Type type) {
        this.type = type;
        return this;
    }

    public InstrumentSpec setBackWood(Wood backWood) {
        this.backWood = backWood;
        return this;
    }

    public InstrumentSpec setFrontWood(Wood frontWood) {
        this.frontWood = frontWood;
        return this;
    }

    public Builder getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public Type getType() {
        return type;
    }

    public Wood getBackWood() {
        return backWood;
    }

    public Wood getFrontWood() {
        return frontWood;
    }

    @Override
    public String toString() {
        return "InstrumentSpec{" +
                "builder=" + builder +
                ", model='" + model + '\'' +
                ", type=" + type +
                ", backWood=" + backWood +
                ", frontWood=" + frontWood +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstrumentSpec that = (InstrumentSpec) o;
        return builder == that.builder && Objects.equals(model, that.model) && type == that.type && backWood == that.backWood && frontWood == that.frontWood;
    }

    @Override
    public int hashCode() {
        return Objects.hash(builder, model, type, backWood, frontWood);
    }
}
