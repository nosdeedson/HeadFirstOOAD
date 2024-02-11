package E3N.com.payroll.payment.method;

import E3N.com.payroll.domain.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MailMethodTest {

    private Address address;

    @BeforeEach
    public void setUp(){
        address = new Address()
                .withNumber("123")
                .withCity("Itajuba")
                .withState("MG")
                .withStreet("Teste")
                .withZipCode("37501-136");
    }

    @Test
    public void shouldInstantiateMailMethod(){
        final var mailMethod = new MailMethod(address);
        Assertions.assertNotNull(mailMethod);
        Assertions.assertNotNull(mailMethod.address());
    }

    @Test
    public void givenAMailMethod_shouldSendThePayment(){
        final var mailMethod = new MailMethod(address);
        Assertions.assertNotNull(mailMethod);
        Assertions.assertNotNull(mailMethod.address());

        final var expectedResult = "Sending salary to ";

        final var result = mailMethod.sendPayment();
        Assertions.assertTrue(result.contains(expectedResult));
    }
}
