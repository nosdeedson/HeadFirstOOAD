package E3N.com.payroll.payment.classification;

import E3N.com.payroll.payment.classification.SalesReceipt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SalesReceiptTest {

    @Test
    public void shouldInstantiateSalesReceipt(){
        SalesReceipt salesReceipt = new SalesReceipt(LocalDate.now(), new BigDecimal("100.00"));
        Assertions.assertNotNull(salesReceipt);
        Assertions.assertNotNull(salesReceipt.getAmount());
        Assertions.assertNotNull(salesReceipt.getDate());
    }
}
