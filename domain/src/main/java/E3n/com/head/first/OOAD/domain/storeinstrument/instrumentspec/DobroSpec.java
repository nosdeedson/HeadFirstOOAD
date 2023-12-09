package E3n.com.head.first.OOAD.domain.storeinstrument.instrumentspec;

import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.Builder;
import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.Type;
import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.Wood;

public class DobroSpec extends InstrumentSpec {
    public DobroSpec(Builder builder, String model, Type type, Wood backWood, Wood frontWood) {
        super(builder, model, type, backWood, frontWood);
    }


}
