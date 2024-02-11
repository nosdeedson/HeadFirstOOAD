package E3N.com.payroll.payment.schedule;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeeklySchedule implements PaymentSchedule{

    @Override
    public boolean triggerPayment() {
        return false;
    }
}
