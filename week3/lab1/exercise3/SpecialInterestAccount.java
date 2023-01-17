/**
 * Used super class mathods:
 * - constructor (InterestAccount)
 * - debit (Account)
 * - credit (Account)
 * - setMonthlyInterestRate (InterestAccount)
 * - toString (InterestAccount)
 */
public class SpecialInterestAccount extends InterestAccount {
    private static final int TRANSACTION_LIMIT = 4;

    private double premiumInterestRate;
    private double regularInterestRate;
    private int transactionCount;

    public SpecialInterestAccount(double balance, double premiumInterestRate, double regularInterestRate) {
        super(balance, premiumInterestRate);
        this.premiumInterestRate = premiumInterestRate;
        this.regularInterestRate = regularInterestRate;
        transactionCount = 0;
    }

    public double getPremiumInterestRate() {
        return premiumInterestRate;
    }

    public void setPremiumInterestRate(double premiumInterestrate) {
        this.premiumInterestRate = premiumInterestrate;
    }

    @Override
    public boolean debit(double amount) {
        transactionCount++;

        if (transactionCount >= TRANSACTION_LIMIT) {
            super.setMonthlyInterestRate(regularInterestRate);
        }

        return super.debit(amount);
    }

    @Override
    public void credit(double amount) {
        transactionCount++;

        if (transactionCount >= TRANSACTION_LIMIT) {
            super.setMonthlyInterestRate(regularInterestRate);
        }

        super.credit(amount);
    }

    @Override
    public String toString() {
        return super.toString() + " Transaction Count: " + transactionCount;
    }
}
