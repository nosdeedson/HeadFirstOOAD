package E3N.com.payroll.payment.schedule;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Timer;
import java.util.TimerTask;

public class MonthlySchedule implements PaymentSchedule{

    @Override
    public boolean triggerPayment() {
        return false;
    }
}
