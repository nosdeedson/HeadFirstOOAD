package E3N.com.payroll.payment.classification;

import java.time.LocalDate;

public class TimeCard {
    private LocalDate date;
    private double hours;

    public TimeCard(LocalDate date, double hours) {
        this.date = date;
        this.hours = hours;
    }

    public double getHours() {
        return hours;
    }

    public LocalDate getDate() {
        return date;
    }
}
