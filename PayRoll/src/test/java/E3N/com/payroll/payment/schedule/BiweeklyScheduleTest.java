package E3N.com.payroll.payment.schedule;

import E3N.com.payroll.domain.Address;
import E3N.com.payroll.domain.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class BiweeklyScheduleTest {

    private Employee employee;

    private LocalDate lastPayDay;

    @BeforeEach
    public void setUp(){
        lastPayDay = LocalDate.of(2024, 1, 5);
        Address address = new Address()
                .withNumber("123")
                .withCity("Itajuba")
                .withState("MG")
                .withStreet("Teste")
                .withZipCode("37501-136");

        this.employee = new Employee("Edson", address);
    }

    @Test
    public void shouldInstantiateABiweeklySchedule(){
        final var scheduler = new BiweeklySchedule();
        Assertions.assertNotNull(scheduler);
    }

    @Test
    public void givenABiweeklySchedule_shouldReturnTrue_ifIsDayOfPayment() throws InterruptedException {
        final var scheduler = new BiweeklySchedule();
        Assertions.assertNotNull(scheduler);
        employee.setPaymentSchedule(scheduler);
        Assertions.assertTrue(employee.getPaymentSchedule().triggerPayment(lastPayDay));
    }

}
