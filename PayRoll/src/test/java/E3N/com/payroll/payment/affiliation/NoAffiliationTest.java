package E3N.com.payroll.payment.affiliation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NoAffiliationTest{

    @Test
    public void shouldInstantiateANoAffiliation(){
        final NoAffiliation noAffiliation = new NoAffiliation();
        Assertions.assertNotNull(noAffiliation);
    }

    @Test
    public void givenANoAffiliation_shouldCalculateCharges(){
        final NoAffiliation noAffiliation = new NoAffiliation();
        Assertions.assertNotNull(noAffiliation);
        final var expectedCharges = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_DOWN);
        final var result = noAffiliation.calculateServiceCharges();
        Assertions.assertEquals(expectedCharges, result);
    }

}
