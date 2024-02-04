package E3N.com.payroll.payment;

import E3N.com.payroll.timecard.TimeCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.*;
import java.util.Locale;

public class HourlyClassificationTest {

    @Test
    public void shouldInstantiateAnHourlyClassification() {
        HourlyClassification hourlyClassification = new HourlyClassification(new BigDecimal(100));
        Assertions.assertNotNull(hourlyClassification);
        Assertions.assertNotNull(hourlyClassification.getHourlyRate());
    }

    @Test
    public void shouldInstantiateAnHourlyClassification_withAnEmptyTimeCards() {
        HourlyClassification hourlyClassification = new HourlyClassification(new BigDecimal(100));
        Assertions.assertNotNull(hourlyClassification);
        Assertions.assertNotNull(hourlyClassification.getHourlyRate());
        Assertions.assertTrue(hourlyClassification.getTimeCards().isEmpty());
    }

    @Test
    public void shouldInstantiateAnHourlyClassification_withTimeCards() {
        final var expectedTimeCard = new TimeCard(LocalDate.now(), 8);
        final var expectedTimeCardsSize = 1;
        HourlyClassification hourlyClassification = new HourlyClassification(new BigDecimal(100));
        hourlyClassification.addTimeCard(expectedTimeCard);
        Assertions.assertNotNull(hourlyClassification);
        Assertions.assertNotNull(hourlyClassification.getHourlyRate());
        Assertions.assertEquals(expectedTimeCardsSize, hourlyClassification.getTimeCards().size());
    }

    @Test
    public void shouldCalculatePay_returnMustBeZero(){
        final var expectedPayment = new BigDecimal("0.00");
        HourlyClassification hourlyClassification = new HourlyClassification(new BigDecimal(100));
        Assertions.assertNotNull(hourlyClassification);
        Assertions.assertNotNull(hourlyClassification.getHourlyRate());
        Assertions.assertEquals(expectedPayment, hourlyClassification.calculatePay());
    }

    @Test
    public void shouldCalculatePay_withOneTimeCard(){
        final var expectedPayment = new BigDecimal("80.00");

        LocalDate date = LocalDate.of(2024, 1, DayOfWeek.FRIDAY.getValue());
        final var expectedTimeCard = new TimeCard(date, 8);
        HourlyClassification hourlyClassification = new HourlyClassification(new BigDecimal(10));
        hourlyClassification.addTimeCard(expectedTimeCard);
        Assertions.assertNotNull(hourlyClassification);
        Assertions.assertNotNull(hourlyClassification.getHourlyRate());
        Assertions.assertEquals(expectedPayment, hourlyClassification.calculatePay());
    }

    @Test
    public void shouldCalculatePay_withTwoTimeCard(){
        final var expectedPayment = new BigDecimal("160.00");

        LocalDate date = LocalDate.of(2024, 1, DayOfWeek.FRIDAY.getValue());
        final var expectedTimeCard = new TimeCard(date, 8);
        final var expectedTimeCard1 = new TimeCard(date, 8);
        HourlyClassification hourlyClassification = new HourlyClassification(new BigDecimal(10));
        hourlyClassification.addTimeCard(expectedTimeCard);
        hourlyClassification.addTimeCard(expectedTimeCard1);
        Assertions.assertNotNull(hourlyClassification);
        Assertions.assertNotNull(hourlyClassification.getHourlyRate());
        Assertions.assertEquals(expectedPayment, hourlyClassification.calculatePay());
    }

    @Test
    public void shouldCalculatePay_withTimeCardsAndExtraTime(){
        // expected payment 80 for one time card plus 80 for the second time card equal to 160
        // extra hour two multiplied by 15 per hour because extra hour is 1.5 of the hourlyRate
        // sum should be 80 + 80 + (2 * (10 * 1.5 ))
        final var expectedPayment = new BigDecimal("190.00");
        LocalDate date = LocalDate.of(2024, 1, DayOfWeek.FRIDAY.getValue());
        final var expectedTimeCard = new TimeCard(date, 8);
        final var expectedTimeCard1 = new TimeCard(date, 10);
        HourlyClassification hourlyClassification = new HourlyClassification(new BigDecimal(10));
        hourlyClassification.addTimeCard(expectedTimeCard);
        hourlyClassification.addTimeCard(expectedTimeCard1);
        Assertions.assertNotNull(hourlyClassification);
        Assertions.assertNotNull(hourlyClassification.getHourlyRate());
        Assertions.assertEquals(expectedPayment, hourlyClassification.calculatePay());
    }

    @Test
    public void shouldNotCalculatePayment_becauseIsNotFriday(){
        final var expectedPayment = new BigDecimal("0.00");
        final var expectedTimeCard = new TimeCard(LocalDate.now(), 8);
        HourlyClassification hourlyClassification = new HourlyClassification(new BigDecimal(10));
        hourlyClassification.addTimeCard(expectedTimeCard);
        Assertions.assertNotNull(hourlyClassification);
        Assertions.assertNotNull(hourlyClassification.getHourlyRate());
        Assertions.assertEquals(expectedPayment, hourlyClassification.calculatePay());
    }

}