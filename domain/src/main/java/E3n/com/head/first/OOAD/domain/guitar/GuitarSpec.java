package E3n.com.head.first.OOAD.domain.guitar;

import java.util.Objects;

public class GuitarSpec {
    private Builder builder;
    private String model;
    private Type type;
    private Wood backWood;
    private Wood frontWood;

    private Integer numberStrings;

    public GuitarSpec(){}

    public GuitarSpec withNumberStrings(Integer numberStrings){
        this.numberStrings = numberStrings;
        return this;
    }


    public GuitarSpec withBuilder(Builder builder) {
        this.builder = builder;
        return this;
    }

    public GuitarSpec withModel(String model) {
        this.model = model;
        return this;
    }

    public GuitarSpec withType(Type type) {
        this.type = type;
        return this;
    }

    public GuitarSpec withBackWood(Wood backWood) {
        this.backWood = backWood;
        return this;
    }

    public GuitarSpec withFrontWood(Wood frontWood) {
        this.frontWood = frontWood;
        return this;
    }

    public Integer getNumberStrings() {
        return numberStrings;
    }

    public Builder getBuilder() {
        return builder;
    }

    public Wood getBackWood() {
        return backWood;
    }

    public Type getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public Wood getFrontWood() {
        return frontWood;
    }

    @Override
    public String toString() {
        return "GuitarSpec{" +
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
        final GuitarSpec spec = (GuitarSpec) o;
        return getBuilder() == spec.getBuilder() && Objects.equals(getModel(), spec.getModel()) && getType() == spec.getType() && getBackWood() == spec.getBackWood() && getFrontWood() == spec.getFrontWood();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBuilder(), getModel(), getType(), getBackWood(), getFrontWood());
    }

}
