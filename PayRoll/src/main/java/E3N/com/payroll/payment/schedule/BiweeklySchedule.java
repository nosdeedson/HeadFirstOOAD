package E3N.com.payroll.payment.schedule;

import java.time.LocalDate;

public class BiweeklySchedule implements PaymentSchedule{

    @Override
    public boolean triggerPayment(final LocalDate lastPayDay) {
        final var nextPayDay = lastPayDay.plusDays(14L);
        final var isPayDay = lastPayDay.plusDays(14L).equals(nextPayDay);
        return isPayDay;
    }
}
