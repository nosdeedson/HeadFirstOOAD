package E3N.com.payroll.payment;

import E3N.com.payroll.sales.SalesReceipt;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class CommissionedClassification implements PayClassification {

    /**
     * basePay is the sum of sales based on SalesReceipt
     */
    private BigDecimal basePay;

    private  double commissionRate;

    private List<SalesReceipt> salesReceipts = new ArrayList<>();

    public CommissionedClassification(double commissionRate) {
        this.commissionRate = commissionRate;
        this.basePay = BigDecimal.ZERO;
    }

    @Override
    public BigDecimal calculatePay() {
        basePay = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_DOWN);
        this.salesReceipts.forEach(salesReceipt -> {
            basePay = basePay.add(salesReceipt.getAmount()).setScale(2, RoundingMode.HALF_DOWN);
        });
        BigDecimal commissionRateInBigDecimal = new BigDecimal(commissionRate).setScale(2, RoundingMode.HALF_DOWN);
        BigDecimal percentage = commissionRateInBigDecimal.divide(new BigDecimal("100")).setScale(2, RoundingMode.HALF_DOWN);
        return basePay.multiply(percentage).setScale(2, RoundingMode.HALF_DOWN);
    }

    public void addSalesReceipts(SalesReceipt salesReceipts) {
        this.salesReceipts.add(salesReceipts);
    }

    public List<SalesReceipt> getSalesReceipts() {
        return salesReceipts;
    }
}
