package E3N.com.payroll.payment;

import E3N.com.payroll.timecard.TimeCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TimeCardTest {

    @Test
    public void shouldInstantiateTimeCard(){
        TimeCard timeCard = new TimeCard(LocalDate.now(), 10);
        Assertions.assertNotNull(timeCard);
        Assertions.assertNotNull(timeCard.getDate());
        Assertions.assertNotNull(timeCard.getHours());
    }
}
