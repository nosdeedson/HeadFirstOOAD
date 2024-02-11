package E3N.com.payroll.payment.classification;

import E3N.com.payroll.payment.classification.CommissionedClassification;
import E3N.com.payroll.payment.classification.SalesReceipt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CommissionClassificationTest {

    @Test
    public void shouldInstantiateCommissionClassificarion(){
        CommissionedClassification commissionedClassification = new CommissionedClassification( 10);
        Assertions.assertNotNull(commissionedClassification);
    }

    @Test
    public void shouldInstantiateCommissionClassificarion_whitSalesReceipts(){
        final var expectedSalesReceipt = new SalesReceipt(LocalDate.now(), new BigDecimal("100.00"));
        final var expectedSalesReceiptsSize = 1;
        CommissionedClassification commissionedClassification = new CommissionedClassification( 10);
        commissionedClassification.addSalesReceipts(expectedSalesReceipt);
        Assertions.assertNotNull(commissionedClassification);
        Assertions.assertEquals(expectedSalesReceiptsSize, commissionedClassification .getSalesReceipts().size());
    }

    @Test
    public void shouldCalculatePayment_whenSalesReceiptsListIsEmpty(){
        final var expectedPayment = new BigDecimal("0.00");
        CommissionedClassification commissionedClassification = new CommissionedClassification( 10);
        Assertions.assertEquals(expectedPayment, commissionedClassification.calculatePay());
        Assertions.assertNotNull(commissionedClassification);
    }

    @Test
    public void shouldCalculatePayment_whenSalesReceiptsListIsNotEmpty(){
        final var expectedSalesReceipt = new SalesReceipt(LocalDate.now(), new BigDecimal("100.00"));
        final var expectedPayment = new BigDecimal("10.00");
        CommissionedClassification commissionedClassification = new CommissionedClassification( 10);
        commissionedClassification.addSalesReceipts(expectedSalesReceipt);
        Assertions.assertEquals(expectedPayment, commissionedClassification.calculatePay());
        Assertions.assertNotNull(commissionedClassification);
    }
}
