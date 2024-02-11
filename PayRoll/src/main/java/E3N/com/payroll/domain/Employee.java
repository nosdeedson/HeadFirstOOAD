package E3N.com.payroll.domain;

import E3N.com.payroll.payment.affiliation.Affiliation;
import E3N.com.payroll.payment.affiliation.NoAffiliation;
import E3N.com.payroll.payment.classification.PayClassification;
import E3N.com.payroll.payment.method.PayMethod;

import java.math.BigDecimal;

public class Employee {

    private String name;
    private Address address;
    private PayClassification payClassification;

    private Affiliation affiliation = new NoAffiliation();

    private PayMethod payMethod;

    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public BigDecimal calculateCharges(){
        return this.getAffiliation().calculateServiceCharges();
    }

    public BigDecimal calculatePayment(){
        return this.getPayClassification().calculatePay();
    }

    public String sendPayment(){
        return this.payMethod.sendPayment();
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }


    public void setPayClassification(PayClassification payClassification) {
        this.payClassification = payClassification;
    }

    public PayClassification getPayClassification() {
        return payClassification;
    }

    public PayMethod getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(PayMethod payMethod) {
        this.payMethod = payMethod;
    }

    public Affiliation getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(Affiliation affiliation) {
        this.affiliation = affiliation;
    }
}
