package E3n.com.head.first.OOAD.domain.guitar;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Guitar> guitars = new ArrayList<>();

    public void addGuitar(final String serialNumber, final double price, final Builder builder, final String model,
                          final Type type, final Wood backWood, final Wood frontWood){
        final var spec = new GuitarSpec()
                .withBuilder(builder)
                .withModel(model)
                .withType(type)
                .withBackWood(backWood)
                .withFrontWood(frontWood);

        final Guitar guitar = new Guitar()
                .withSerialNumber(serialNumber)
                .withPrice(price)
                .withSpec(spec);
        this.guitars.add(guitar);
    }

    public List<Guitar> getGuitars() {
        return guitars;
    }

    public List<Guitar> search(List<Guitar> list, GuitarSpec expected) {
        return this.guitars.stream().filter(it -> it.getSpec().equals(expected)).toList();
    }
}
