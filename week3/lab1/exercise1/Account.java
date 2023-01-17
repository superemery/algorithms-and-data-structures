public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void credit(double amount) {
        balance += amount;
    }

    public boolean debit(double amount) {
        if (balance - amount < 0)
            return false;

        balance -= amount;
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double newBalance) {
        balance = newBalance;
    }

    public String toString() {
        return super.toString() + " Balance : " + balance;
    }
}