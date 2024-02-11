package E3N.com.payroll.payment.affiliation;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NoAffiliation implements Affiliation {

    @Override
    public BigDecimal calculateServiceCharges() {
        return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_DOWN);
    }
}
