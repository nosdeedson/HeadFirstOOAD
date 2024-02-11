package E3N.com.payroll.payment.method;

public class DirectMethod implements PayMethod{

    private String bank;
    private String account;

    public DirectMethod(String bank, String account) {
        this.bank = bank;
        this.account = account;
    }

    @Override
    public String sendPayment() {
        return "Transfering the salary to " + this.toString();
    }

    public String getBank() {
        return bank;
    }

    public String getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "bank='" + bank + '\'' +
                ", account='" + account + '\'';
    }
}
