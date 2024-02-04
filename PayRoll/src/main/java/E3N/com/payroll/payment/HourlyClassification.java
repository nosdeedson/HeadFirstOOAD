package E3N.com.payroll.payment;

import E3N.com.payroll.timecard.TimeCard;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HourlyClassification implements PayClassification{

    private BigDecimal hourlyRate;
    private List<TimeCard> timeCards = new ArrayList<>();

    public HourlyClassification(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void addTimeCard(TimeCard timeCard){
        this.timeCards.add(timeCard);
    }

    @Override
    public BigDecimal calculatePay() {
        BigDecimal total = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_DOWN);
        for(TimeCard timeCard: timeCards){
            if (!timeCard.getDate().getDayOfWeek().equals(DayOfWeek.FRIDAY) ){
                continue;
            }
            if (timeCard.getHours() > 8){
                BigDecimal workedHours = new BigDecimal(timeCard.getHours()).setScale(2, RoundingMode.HALF_DOWN);
                BigDecimal extraHourWorked =workedHours.subtract(new BigDecimal("8"));
                BigDecimal normalHour = workedHours.subtract(extraHourWorked);
                total = total.add(this.calculateNormalHour(normalHour));
                total = total.add(this.calculateExtraHour(extraHourWorked));
            } else{
                BigDecimal hourWorked = new BigDecimal(timeCard.getHours()).setScale(2, RoundingMode.HALF_DOWN);
                BigDecimal normalHour = this.calculateNormalHour(hourWorked);
                total  = total.add(normalHour);
            }
        }
        return total;
    }

    private BigDecimal calculateNormalHour(BigDecimal hour){
        return hour.multiply(hourlyRate).setScale(2, RoundingMode.HALF_DOWN);
    }

    private BigDecimal calculateExtraHour(BigDecimal extraHour){
        BigDecimal extraHourRate = hourlyRate.multiply(new BigDecimal("1.5"));
        return  extraHourRate.multiply(extraHour).setScale(2, RoundingMode.HALF_DOWN);
    }

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public List<TimeCard> getTimeCards() {
        return timeCards;
    }
}
