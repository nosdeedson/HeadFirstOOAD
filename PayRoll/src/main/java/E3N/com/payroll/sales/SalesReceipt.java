package E3N.com.payroll.sales;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SalesReceipt {

    private LocalDate date;
    private BigDecimal amount;

    public SalesReceipt(LocalDate date, BigDecimal amount) {
        this.date = date;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
