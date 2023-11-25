package E3n.com.head.first.OOAD.domain.guitar;

public class Guitar {

    private String serialNumber;
    private double price;

    private GuitarSpec spec;

    public Guitar(){}



    @Override
    public String toString() {
        return "Guitar{" +
                "serialNumber='" + serialNumber + '\'' +
                ", price=" + price +
                ", spec=" + spec.toString() +
                '}';
    }

    public Guitar withSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    public Guitar withPrice(double price) {
        this.price = price;
        return this;
    }

    public Guitar withSpec(GuitarSpec spec) {
        this.spec = spec;
        return this;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public GuitarSpec getSpec() {
        return spec;
    }
}
