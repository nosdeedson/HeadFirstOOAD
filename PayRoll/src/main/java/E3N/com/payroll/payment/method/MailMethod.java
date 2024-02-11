package E3N.com.payroll.payment.method;

import E3N.com.payroll.domain.Address;

public record MailMethod(Address address) implements PayMethod {

    @Override
    public String sendPayment() {
        return "Sending salary to " + address.toString();
    }
}
