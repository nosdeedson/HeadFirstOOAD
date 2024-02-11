package E3N.com.payroll.domain;

import E3N.com.payroll.payment.affiliation.NoAffiliation;
import E3N.com.payroll.payment.affiliation.ServiceCharge;
import E3N.com.payroll.payment.affiliation.UnionAffiliation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class EmployeeAffiliationTest {

    private Employee employee;

    @BeforeEach
    public void setUp(){
        Address address = new Address()
                .withNumber("123")
                .withCity("Itajuba")
                .withState("MG")
                .withStreet("Teste")
                .withZipCode("37501-136");

        this.employee = new Employee("Edson", address);
    }

    @Test
    public void givenAnEmployee_itShoulHaveANoAffiliationByDefault(){
        Assertions.assertNotNull(employee);
        Assertions.assertNotNull(employee.getAddress());
        Assertions.assertNotNull(employee.getName());
        Assertions.assertTrue(employee.getAffiliation() instanceof NoAffiliation);
    }

    @Test
    public void givenAnEmployee_withUnionAffiliation_duesSizeMustBeNone(){
        final var expectedDues = 0;
        employee.setAffiliation(new UnionAffiliation());
        Assertions.assertTrue(employee.getAffiliation() instanceof UnionAffiliation);
        Assertions.assertEquals(expectedDues, ((UnionAffiliation) employee.getAffiliation()).getDues().size());
    }

    @Test
    public void givenAnEmployee_withUnionAffiliation_andDues_shouldCalculateTheAmountOfCharges(){
        final var expectedTotalCharges = new BigDecimal("30.00");
        final UnionAffiliation unionAffiliation = new UnionAffiliation();
        Assertions.assertNotNull(unionAffiliation);
        unionAffiliation.getDues().addAll(List.of(
                new ServiceCharge(BigDecimal.TEN.setScale(2, RoundingMode.HALF_DOWN)),
                new ServiceCharge(BigDecimal.TEN.setScale(2, RoundingMode.HALF_DOWN)),
                new ServiceCharge(BigDecimal.TEN.setScale(2, RoundingMode.HALF_DOWN))
        ));
        employee.setAffiliation(unionAffiliation);
        final var result = employee.calculateCharges();
        Assertions.assertEquals(expectedTotalCharges, result);
    }
}
