package E3N.com.payroll.payment.schedule;

public class BiweeklySchedule implements PaymentSchedule{
    @Override
    public boolean triggerPayment() {
        return false;
    }
}
