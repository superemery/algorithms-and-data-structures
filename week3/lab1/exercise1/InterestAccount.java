public class InterestAccount extends Account {
    private double monthlyInterestRate;

    public InterestAccount(double balance, double monthlyInterestRate) {
        super(balance);
        this.monthlyInterestRate = monthlyInterestRate;
    }

    public void addMonthlyInterest() {
        double currentBalance = super.getBalance();
        double interest = currentBalance * monthlyInterestRate;

        super.credit(interest);
    }

    public double getMonthlyInterestRate() {
        return monthlyInterestRate;
    }

    public void setMonthlyInterestRate(double monthlyInterestRate) {
        this.monthlyInterestRate = monthlyInterestRate;
    }

    @Override
    public String toString() {
        return super.toString() + " Monthly Interest Rate : " + monthlyInterestRate;
    }
}
