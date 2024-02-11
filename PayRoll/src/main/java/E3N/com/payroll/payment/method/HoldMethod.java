package E3N.com.payroll.payment.method;

public class HoldMethod implements PayMethod{
    @Override
    public String sendPayment() {
        return "Manager holding the salary";
    }
}
