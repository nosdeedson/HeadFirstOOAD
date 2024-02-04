package E3N.com.payroll.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressTest {

    @Test
    public void shouldInstanciateAnAddress(){
        Address address = new Address()
                .withZipCode("37501-135")
                .withNumber("123")
                .withState("MG")
                .withStreet("TESTE")
                .withCity("itajuba");
        Assertions.assertNotNull(address);
        Assertions.assertNotNull(address.getCity());
        Assertions.assertNotNull(address.getNumber());
        Assertions.assertNotNull(address.getState());
        Assertions.assertNotNull(address.getStreet());
        Assertions.assertNotNull(address.getZipCode());
    }
}
