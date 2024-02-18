package E3N.com.payroll.payment.schedule;

import E3N.com.payroll.domain.Address;
import E3N.com.payroll.domain.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class MontlyScheduleTest {

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
    public void shouldInstantiateAMonthlySchedule(){
        final var schedule = new MonthlySchedule();
        Assertions.assertNotNull(schedule);
    }

    @Test
    public void givenAMonthlySchedule_shouldReturnFalseIfNotLastFriday(){
        final var schedule = new MonthlySchedule();
        Assertions.assertNotNull(schedule);
        employee.setPaymentSchedule(schedule);
        final var result = employee.getPaymentSchedule().triggerPayment(LocalDate.now());
        Assertions.assertFalse(result);
    }

    @Test
    public void givenAMonthlySchedule_shouldReturnTrueIfLastFriday(){
        final var schedule = new MonthlySchedule();
        Assertions.assertNotNull(schedule);
        employee.setPaymentSchedule(schedule);
        final var lastFriday = LocalDate.of(2024, 2, 23);
        final var result = employee.getPaymentSchedule().triggerPayment(lastFriday);
        Assertions.assertTrue(result);
    }

    @Test
    public void givenAMonthlySchedule_shouldReturnTrueIfLastFriday_andDateIsNotLastFriday(){
        final var schedule = new MonthlySchedule();
        Assertions.assertNotNull(schedule);
        employee.setPaymentSchedule(schedule);
        final var lastFriday = LocalDate.of(2024, 2, 16);
        final var result = employee.getPaymentSchedule().triggerPayment(lastFriday);
        Assertions.assertFalse(result);
    }

    @Test
    public void givenAMonthlySchedule_shouldReturnTrueIfDateIsLastFriday(){
        final var schedule = new MonthlySchedule();
        Assertions.assertNotNull(schedule);
        employee.setPaymentSchedule(schedule);
        final var lastFriday = LocalDate.of(2024, 3, 29);
        final var result = employee.getPaymentSchedule().triggerPayment(lastFriday);
        Assertions.assertTrue(result);
    }

    @Test
    public void givenAMonthlySchedule_shouldReturnTrueIfDateIsLastFriday2(){
        final var schedule = new MonthlySchedule();
        Assertions.assertNotNull(schedule);
        employee.setPaymentSchedule(schedule);
        final var lastFriday = LocalDate.of(2024, 4, 26);
        final var result = employee.getPaymentSchedule().triggerPayment(lastFriday);
        Assertions.assertTrue(result);
    }
}
