package E3N.com.payroll.domain;

import E3N.com.payroll.domain.Address;
import E3N.com.payroll.domain.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class EmployeeTest {

    @Test
    public void shouldInstanciateAEmployee(){
        Address address = new Address()
                .withNumber("123")
                .withCity("Itajuba")
                .withState("MG")
                .withStreet("Teste")
                .withZipCode("37501-136");

        Employee employee = new Employee("Edson", address, new BigDecimal("1.500"));

        Assertions.assertNotNull(employee);
        Assertions.assertNotNull(employee.getAddress());
        Assertions.assertNotNull(employee.getName());
        Assertions.assertNotNull(employee.getSalary());
    }
}
