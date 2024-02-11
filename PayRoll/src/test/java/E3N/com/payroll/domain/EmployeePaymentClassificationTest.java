package E3N.com.payroll.domain;

import E3N.com.payroll.payment.classification.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class EmployeePaymentClassificationTest {

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
    public void givenAnEmployeeWithComissionedClassification_withoutSalesReceipts_shouldCalculatePayment() {
        final var expectedPayment = new BigDecimal("0.00");
        employee.setPayClassification(new CommissionedClassification(10));
        final var payment = employee.calculatePayment();
        Assertions.assertEquals(expectedPayment, payment);
    }

    @Test
    public void givenAnEmployeeWithComissionedClassification_andSalesReceipts_shouldCalculatePayment() {

        final var expectedComissionClassification = new CommissionedClassification(10);
        final var sale1 = new SalesReceipt(LocalDate.now(), BigDecimal.valueOf(100));
        final var sale2 = new SalesReceipt(LocalDate.now(), BigDecimal.valueOf(200));
        expectedComissionClassification.addSalesReceipts(sale2);
        expectedComissionClassification.addSalesReceipts(sale1);

        final var expectedPayment = new BigDecimal("30.00");
        employee.setPayClassification(expectedComissionClassification);

        final var payment = employee.calculatePayment();
        Assertions.assertEquals(expectedPayment, payment);
    }

    @Test
    public void givenAnEmployeeWithSalariedClassification_shouldCalculatePayment() {

        final var expectedPayment = new BigDecimal("1000.00");
        employee.setPayClassification(new SalariedClassification(new BigDecimal("1000.00")));

        final var payment = employee.calculatePayment();
        Assertions.assertEquals(expectedPayment, payment);
    }

    @Test
    public void givenAnEmployeeWithHourlyClassification_withoutTimeCards_shouldCalculatePayment() {

        employee.setPayClassification(new HourlyClassification(new BigDecimal("10")));
        final var expectedSalary = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_DOWN);
        final var payment = employee.calculatePayment();
        Assertions.assertEquals(expectedSalary, payment);
    }

    @Test
    public void givenAnEmployeeWithHourlyClassification_withTimeCards_shouldCalculatePayment() {

        LocalDate date = LocalDate.of(2024, 1, DayOfWeek.FRIDAY.getValue());
        TimeCard timeCard = new TimeCard(date, 8);
        TimeCard timeCard1 = new TimeCard(date, 8);
        TimeCard timeCard2 = new TimeCard(date, 8);
        final var hourlyClassification = new HourlyClassification(BigDecimal.TEN.setScale(2, RoundingMode.HALF_DOWN));
        hourlyClassification.addTimeCard(timeCard);
        hourlyClassification.addTimeCard(timeCard1);
        hourlyClassification.addTimeCard(timeCard2);
        employee.setPayClassification(hourlyClassification);

        final var expectedSalary = new BigDecimal("240.00");
        final var payment = employee.calculatePayment();
        Assertions.assertEquals(expectedSalary, payment);
    }

    @Test
    public void givenAnEmployeeWithHourlyClassification_withTimeCards_andOverTime_shouldCalculatePayment() {

        LocalDate date = LocalDate.of(2024, 1, DayOfWeek.FRIDAY.getValue());
        TimeCard timeCard = new TimeCard(date, 8); // 80
        TimeCard timeCard1 = new TimeCard(date, 8); // 80
        TimeCard timeCard2 = new TimeCard(date, 10); // 80 plus 30
        final var hourlyClassification = new HourlyClassification(BigDecimal.TEN.setScale(2, RoundingMode.HALF_DOWN));
        hourlyClassification.addTimeCard(timeCard);
        hourlyClassification.addTimeCard(timeCard1);
        hourlyClassification.addTimeCard(timeCard2);
        employee.setPayClassification(hourlyClassification);

        final var expectedSalary = new BigDecimal("270.00");
        final var payment = employee.calculatePayment();
        Assertions.assertEquals(expectedSalary, payment);
    }


}
