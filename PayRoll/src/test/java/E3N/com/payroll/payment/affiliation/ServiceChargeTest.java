package E3N.com.payroll.payment.affiliation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ServiceChargeTest {

    @Test
    public void shouldInstantiateAServiceCharge(){
        final ServiceCharge serviceCharge = new ServiceCharge(BigDecimal.TEN);
        final var expectedCharge = BigDecimal.TEN;
        Assertions.assertNotNull(serviceCharge);
        Assertions.assertNotNull(serviceCharge.getCharge());
        Assertions.assertEquals(expectedCharge, serviceCharge.getCharge());
    }
}
