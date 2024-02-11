package E3N.com.payroll.payment.affiliation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class UnionAffiliationTest {

    @Test
    public void shouldInstantiateAUnionAffiliation(){
        final UnionAffiliation unionAffiliation = new UnionAffiliation();
        Assertions.assertNotNull(unionAffiliation);
        final var expectedDues = 0;
        Assertions.assertEquals(expectedDues, unionAffiliation.getDues().size());
    }

    @Test
    public void givenAnUnionAffiliation_shouldBePossibleToAddServiceCharge(){
        final UnionAffiliation unionAffiliation = new UnionAffiliation();
        Assertions.assertNotNull(unionAffiliation);
        final var expectedDues = 3;
        unionAffiliation.getDues().addAll(List.of(
                new ServiceCharge(BigDecimal.ONE),
                new ServiceCharge(BigDecimal.TEN),
                new ServiceCharge(BigDecimal.TEN)
        ));
        Assertions.assertEquals(expectedDues, unionAffiliation.getDues().size());
    }

    @Test
    public void givenAnUnionAffiliation_shouldCalculateCharges(){
        final UnionAffiliation unionAffiliation = new UnionAffiliation();
        Assertions.assertNotNull(unionAffiliation);
        final var expectedTotalCharges = new BigDecimal("30.00");
        unionAffiliation.getDues().addAll(List.of(
                new ServiceCharge(BigDecimal.TEN.setScale(2, RoundingMode.HALF_DOWN)),
                new ServiceCharge(BigDecimal.TEN.setScale(2, RoundingMode.HALF_DOWN)),
                new ServiceCharge(BigDecimal.TEN.setScale(2, RoundingMode.HALF_DOWN))
        ));
        final var charges = unionAffiliation.calculateServiceCharges();
        Assertions.assertEquals(expectedTotalCharges, charges);
    }
}
