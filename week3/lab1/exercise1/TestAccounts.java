
public class TestAccounts {
      public static void main(String args[]) {
            final double balance = 10000;
            final double rate1 = 0.25;
            final double rate2 = 0.1;

            InterestAccount account = new InterestAccount(balance, rate1);
            account.addMonthlyInterest();
            System.out.println(account);

            account.setMonthlyInterestRate(rate2);
            account.addMonthlyInterest();
            System.out.println(account);
      }
}
