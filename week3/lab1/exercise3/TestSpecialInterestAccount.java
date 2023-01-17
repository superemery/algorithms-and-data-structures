public class TestSpecialInterestAccount {
    public static void main(String[] args) {
        final double balance = 50000;
        final double regularRate = 0.15;
        final double premiumRate = 0.24;

        SpecialInterestAccount account = new SpecialInterestAccount(balance, premiumRate, regularRate);
        account.addMonthlyInterest();
        System.out.println(account);

        account.debit(1000);
        account.credit(5000);
        account.addMonthlyInterest();
        System.out.println(account);

        account.debit(1000);
        account.debit(4000);
        account.credit(5000);
        account.addMonthlyInterest();
        System.out.println(account);
    }
}
