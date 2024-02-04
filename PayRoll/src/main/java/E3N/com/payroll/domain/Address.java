package E3N.com.payroll.domain;

public class Address {

    private String number;
    private String street;

    private String zipCode;

    private String state;

    private String city;

    public Address() {}

    public Address withNumber(String number) {
        this.number = number;
        return this;
    }

    public Address withStreet(String street) {
        this.street = street;
        return this;
    }

    public Address withZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public Address withState(String state) {
        this.state = state;
        return this;
    }

    public Address withCity(String city) {
        this.city = city;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }
}
