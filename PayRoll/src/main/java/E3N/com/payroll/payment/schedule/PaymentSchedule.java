package E3N.com.payroll.payment.schedule;

import E3N.com.payroll.domain.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface PaymentSchedule {
    boolean triggerPayment(final LocalDate date);
}
