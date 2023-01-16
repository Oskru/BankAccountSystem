public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(double balance, String accountNumber, double interestRate) {
        super(balance, accountNumber);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > this.getBalance()) {
            return false;
        }
        this.setBalance(this.getBalance() - amount);
        return true;
    }
}
