package E3n.com.head.first.OOAD.domain.v2.storeinstrument.instrumentSpecs;

import E3n.com.head.first.OOAD.domain.v2.storeinstrument.enumerates.Builder;
import E3n.com.head.first.OOAD.domain.v2.storeinstrument.enumerates.Style;
import E3n.com.head.first.OOAD.domain.v2.storeinstrument.enumerates.Type;
import E3n.com.head.first.OOAD.domain.v2.storeinstrument.enumerates.Wood;

import java.util.Objects;

public class InstrumentSpec {

    private final Builder builder;
    private final String model;
    private final Type type;
    private final Wood backwood;
    private final Wood frontwood;
    private Style mandolinStyle;
    private String fiddleFinish;
    private Integer numberString;

    public InstrumentSpec(Builder builder, String model, Type type, Wood backwood, Wood frontwood) {
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backwood = backwood;
        this.frontwood = frontwood;
    }

    public void setMandolinStyle(Style mandolinStyle) {
        this.mandolinStyle = mandolinStyle;
    }

    public void setFiddleFinish(String fiddleFinish) {
        this.fiddleFinish = fiddleFinish;
    }

    public void setNumberString(Integer numberString) {
        this.numberString = numberString;
    }

    public Style getMandolinStyle() {
        return mandolinStyle;
    }

    public String getFiddleFinish() {
        return fiddleFinish;
    }

    public Integer getNumberString() {
        return numberString;
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

    public Wood getBackwood() {
        return backwood;
    }

    public Wood getFrontwood() {
        return frontwood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final InstrumentSpec that = (InstrumentSpec) o;
        final var modelEqual = Objects.equals(model, that.model);
        return modelEqual || builder == that.builder || type == that.type || backwood == that.backwood || frontwood == that.frontwood;
    }

    @Override
    public int hashCode() {
        return Objects.hash(builder, model, type, backwood, frontwood);
    }
}
