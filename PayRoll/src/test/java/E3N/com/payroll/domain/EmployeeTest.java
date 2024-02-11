package E3N.com.payroll.domain;

import E3N.com.payroll.payment.affiliation.NoAffiliation;
import E3N.com.payroll.payment.affiliation.UnionAffiliation;
import E3N.com.payroll.payment.classification.*;
import E3N.com.payroll.payment.method.DirectMethod;
import E3N.com.payroll.payment.method.HoldMethod;
import E3N.com.payroll.payment.method.MailMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class EmployeeTest {

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
    public void shouldInstanciateAEmployee() {
        Assertions.assertNotNull(employee);
        Assertions.assertNotNull(employee.getAddress());
        Assertions.assertNotNull(employee.getName());
    }


    @Test
    public void givenAnEmployeeWithComissionedClassification_shouldBeAbleToChangeTo_SalariedClassification() {
        employee.setPayClassification(new CommissionedClassification(10));
        Assertions.assertTrue(employee.getPayClassification() instanceof CommissionedClassification);
        employee.setPayClassification(new SalariedClassification(new BigDecimal("1000.00")));
        Assertions.assertTrue(employee.getPayClassification() instanceof SalariedClassification);
    }

    @Test
    public void givenAnEmployeeWithComissionedClassification_shouldBeAbleToChangeTo_HourlyClassification() {
        employee.setPayClassification(new CommissionedClassification(10));
        Assertions.assertTrue(employee.getPayClassification() instanceof CommissionedClassification);
        employee.setPayClassification(new HourlyClassification(BigDecimal.TEN));
        Assertions.assertTrue(employee.getPayClassification() instanceof HourlyClassification);
    }

    @Test
    public void givenAnEmployeeWithSalariedClassification_shouldBeAbleToChangeTo_ComissionedClassification() {
        employee.setPayClassification(new SalariedClassification(new BigDecimal("1000.00")));
        Assertions.assertTrue(employee.getPayClassification() instanceof SalariedClassification);
        employee.setPayClassification(new CommissionedClassification(10));
        Assertions.assertTrue(employee.getPayClassification() instanceof CommissionedClassification);
    }

    @Test
    public void givenAnEmployeeWithSalariedClassification_shouldBeAbleToChangeTo_HourlyClassification() {
        employee.setPayClassification(new SalariedClassification(new BigDecimal("1000.00")));
        Assertions.assertTrue(employee.getPayClassification() instanceof SalariedClassification);
        employee.setPayClassification(new HourlyClassification(BigDecimal.TEN));
        Assertions.assertTrue(employee.getPayClassification() instanceof HourlyClassification);
    }

    @Test
    public void givenAnEmployeeWithHourlyClassification_shouldBeAbleToChangeTo_ComissionedClassification() {
        employee.setPayClassification(new HourlyClassification(BigDecimal.TEN));
        Assertions.assertTrue(employee.getPayClassification() instanceof HourlyClassification);
        employee.setPayClassification(new CommissionedClassification(10));
        Assertions.assertTrue(employee.getPayClassification() instanceof CommissionedClassification);
    }

    @Test
    public void givenAnEmployeeWithHourlyClassification_shouldBeAbleToChangeTo_SalariedClassification() {
        employee.setPayClassification(new HourlyClassification(BigDecimal.TEN));
        Assertions.assertTrue(employee.getPayClassification() instanceof HourlyClassification);
        employee.setPayClassification(new SalariedClassification(BigDecimal.TEN));
        Assertions.assertTrue(employee.getPayClassification() instanceof SalariedClassification);
    }

    @Test
    public void givenAnEmployee_withPayment_HoldMethod_shouldChangeTo_DirectMethod(){
        final HoldMethod holdMethod = new HoldMethod();
        employee.setPayMethod(holdMethod);
        Assertions.assertTrue(employee.getPayMethod() instanceof HoldMethod );
        employee.setPayMethod(new DirectMethod("bank", "1234"));
        Assertions.assertTrue(employee.getPayMethod() instanceof DirectMethod );
    }

    @Test
    public void givenAnEmployee_withPayment_HoldMethod_shouldChangeTo_MailMethod(){
        final HoldMethod holdMethod = new HoldMethod();
        employee.setPayMethod(holdMethod);
        Assertions.assertTrue(employee.getPayMethod() instanceof HoldMethod );
        employee.setPayMethod(new MailMethod(employee.getAddress()));
        Assertions.assertTrue(employee.getPayMethod() instanceof MailMethod );
    }

    @Test
    public void givenAnEmployee_withPayment_mailMethod_shouldChangeTo_HoldMethod(){
        employee.setPayMethod(new MailMethod(employee.getAddress()));
        Assertions.assertTrue(employee.getPayMethod() instanceof MailMethod );
        employee.setPayMethod(new HoldMethod());
        Assertions.assertTrue(employee.getPayMethod() instanceof HoldMethod );
    }

    @Test
    public void givenAnEmployee_withPayment_mailMethod_shouldChangeTo_DirectMethod(){
        employee.setPayMethod(new MailMethod(employee.getAddress()));
        Assertions.assertTrue(employee.getPayMethod() instanceof MailMethod );
        employee.setPayMethod(new DirectMethod("bank", "1234"));
        Assertions.assertTrue(employee.getPayMethod() instanceof DirectMethod );
    }

    @Test
    public void givenAnEmployee_withPayment_directMethod_shouldChangeTo_mailMethod(){
        employee.setPayMethod(new DirectMethod("bank", "1234"));
        Assertions.assertTrue(employee.getPayMethod() instanceof DirectMethod );
        employee.setPayMethod(new MailMethod(employee.getAddress()));
        Assertions.assertTrue(employee.getPayMethod() instanceof MailMethod );
    }

    @Test
    public void givenAnEmployee_withPayment_directMethod_shouldChangeTo_holdMethod(){
        employee.setPayMethod(new DirectMethod("bank", "1234"));
        Assertions.assertTrue(employee.getPayMethod() instanceof DirectMethod );
        employee.setPayMethod(new HoldMethod());
        Assertions.assertTrue(employee.getPayMethod() instanceof HoldMethod );
    }

    @Test
    public void givenAnEmployee_shouldBePossibleToChange_toUnionAffiliation(){
        Assertions.assertNotNull(employee);
        Assertions.assertTrue(employee.getAffiliation() instanceof NoAffiliation);
        employee.setAffiliation(new UnionAffiliation());
        Assertions.assertTrue(employee.getAffiliation() instanceof UnionAffiliation);
    }
}
