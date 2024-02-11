package E3N.com.payroll.domain;

import E3N.com.payroll.payment.method.DirectMethod;
import E3N.com.payroll.payment.method.HoldMethod;
import E3N.com.payroll.payment.method.MailMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeePaymentMethodTest {

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
    public void givenAnEmployeeWithPaymentHoldMethod_shoulSendPayment(){
        final var expectedResult = "Manager holding the salary";
        final HoldMethod holdMethod = new HoldMethod();
        employee.setPayMethod(holdMethod);
        final var result = employee.sendPayment();
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void givenAnEmployeeWithPaymentDirectMethod_shoulSendPayment(){
        final var expectedResult = "Transfering the salary to ";
        final DirectMethod directMethod = new DirectMethod("American Express", "12345") ;
        employee.setPayMethod(directMethod);
        final var result = employee.sendPayment();
        Assertions.assertTrue(result.startsWith(expectedResult));
    }

    @Test
    public void givenAnEmployeeWithPaymentMailMethod_shoulSendPayment(){
        final var expectedResult = "Sending salary to " + employee.getAddress().toString();
        final MailMethod mailMethod = new MailMethod(employee.getAddress()) ;
        employee.setPayMethod(mailMethod);
        final var result = employee.sendPayment();
        Assertions.assertEquals(expectedResult, result);
    }
}
