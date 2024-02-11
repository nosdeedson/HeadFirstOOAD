package E3N.com.payroll.payment.classification;

import java.math.BigDecimal;

public class SalariedClassification implements PayClassification{

    private BigDecimal monthlyPay;

    public SalariedClassification(BigDecimal monthlyPay) {
        this.monthlyPay = monthlyPay;
    }

    @Override
    public BigDecimal calculatePay() {
        return monthlyPay;
    }
}
