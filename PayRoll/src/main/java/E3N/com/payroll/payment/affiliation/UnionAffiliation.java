package E3N.com.payroll.payment.affiliation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class UnionAffiliation implements Affiliation {

    private List<ServiceCharge> dues = new ArrayList<>();

    public void addServiceCharge(final ServiceCharge serviceCharge){
        dues.add(serviceCharge);
    }

    public List<ServiceCharge> getDues() {
        return dues;
    }

    @Override
    public BigDecimal calculateServiceCharges() {
        BigDecimal allCharges = new BigDecimal("0.00").setScale(2, RoundingMode.HALF_DOWN);
        for(ServiceCharge sc: dues){
            allCharges = allCharges.add(sc.getCharge()).setScale(2, RoundingMode.HALF_DOWN);
        }
        return allCharges;
    }
}
