package E3N.com.payroll.payment.affiliation;

import java.math.BigDecimal;

public class ServiceCharge {

    private BigDecimal charge;

    public ServiceCharge(BigDecimal charge) {
        this.charge = charge;
    }

    public BigDecimal getCharge() {
        return charge;
    }
}
