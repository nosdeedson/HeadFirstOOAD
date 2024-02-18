package E3N.com.payroll.payment.schedule;

import E3N.com.payroll.domain.Address;
import E3N.com.payroll.domain.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class WeeklyScheduleTest {
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
    public void shouldInstantiateAWeeklySchedule(){
        final var schedule = new  WeeklySchedule();
        Assertions.assertNotNull(schedule);
    }

    @Test
    public void givenAWeeklySchedule_shouldReturnTrue(){
        final var schedule = new  WeeklySchedule();
        Assertions.assertNotNull(schedule);
        employee.setPaymentSchedule(schedule);
        final var payDay = LocalDate.of(2024, 2, 16);
        Assertions.assertTrue(employee.getPaymentSchedule().triggerPayment(payDay));
    }

    @Test
    public void givenAWeeklySchedule_shouldReturnFalse(){
        final var schedule = new  WeeklySchedule();
        Assertions.assertNotNull(schedule);
        employee.setPaymentSchedule(schedule);
        final var payDay = LocalDate.now();
        Assertions.assertFalse(employee.getPaymentSchedule().triggerPayment(payDay));
    }
}
