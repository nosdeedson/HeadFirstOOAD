package E3N.com.payroll.payment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class SalariedClassificationTest {

    @Test
    public void shouldInstantiateSalariedClassification(){
        SalariedClassification salariedClassification = new SalariedClassification(new BigDecimal("100.00"));
        Assertions.assertNotNull(salariedClassification);
    }
}
