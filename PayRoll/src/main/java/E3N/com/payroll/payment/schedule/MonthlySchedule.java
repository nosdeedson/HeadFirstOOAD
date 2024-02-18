package E3N.com.payroll.payment.schedule;

import E3N.com.payroll.domain.Employee;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class MonthlySchedule implements PaymentSchedule{


    @Override
    public boolean triggerPayment(final LocalDate date) {
        var toCompare = date;
        Integer lastDayOfMonth = 0;
        final var minDayToCalc = date.getDayOfMonth();
        if (minDayToCalc > 22) {
            while (toCompare.getMonth().equals(date.getMonth())) {
                lastDayOfMonth = toCompare.getDayOfMonth();
                toCompare = toCompare.plusDays(1L);
            }
            int quantityDays = lastDayOfMonth - date.getDayOfMonth();
            if (quantityDays < 7) {
                return true;
            }
        }
        return false;
    }

}
