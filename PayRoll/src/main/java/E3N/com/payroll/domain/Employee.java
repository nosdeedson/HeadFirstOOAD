package E3N.com.payroll.domain;

import E3N.com.payroll.payment.PayClassification;

import java.math.BigDecimal;

public class Employee {

    private String name;
    private Address address;
    private PayClassification payClassification;
    private BigDecimal salary;

    public Employee(String name, Address address, BigDecimal salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setPayClassification(PayClassification payClassification) {
        this.payClassification = payClassification;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = this.salary.add(this.payClassification.calculatePay());
    }
}
