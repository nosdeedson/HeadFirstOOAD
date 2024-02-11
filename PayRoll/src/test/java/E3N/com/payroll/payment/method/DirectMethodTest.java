package E3N.com.payroll.payment.method;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DirectMethodTest {

    @Test
    public void shouldInstantiateADirectMethod(){
        final DirectMethod directMethod = new DirectMethod("American Express", "12345");
        Assertions.assertNotNull(directMethod);
        Assertions.assertNotNull(directMethod.getAccount());
        Assertions.assertNotNull(directMethod.getBank());
    }

    @Test
    public void givenADirectMethod_shouldTransferPayment(){
        final DirectMethod directMethod = new DirectMethod("American Express", "12345");
        Assertions.assertNotNull(directMethod);
        Assertions.assertNotNull(directMethod.getAccount());
        Assertions.assertNotNull(directMethod.getBank());

        final var expectedResult = "Transfering the salary to ";

        final var result = directMethod.sendPayment();
        Assertions.assertTrue(result.startsWith(expectedResult));
    }

}
