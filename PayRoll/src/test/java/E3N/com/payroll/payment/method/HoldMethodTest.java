package E3N.com.payroll.payment.method;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HoldMethodTest {

    @Test
    public void shouldInstantiateHoldMethod(){
        final HoldMethod holdMethod = new HoldMethod();
        Assertions.assertNotNull(holdMethod);
    }

    @Test
    public void givenAHoldMethod_shouldHoldThePayment(){
        final var expectedResult = "Manager holding the salary";
        final HoldMethod holdMethod = new HoldMethod();
        final  var result = holdMethod.sendPayment();
        Assertions.assertNotNull(holdMethod);
        Assertions.assertEquals(expectedResult, result);
    }
}
