public class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(double balance, String accountNumber, double overdraftLimit) {
        super(balance, accountNumber);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > this.getBalance() + this.overdraftLimit) {
            return false;
        }
        this.setBalance(this.getBalance() - amount);
        return true;
    }
}
