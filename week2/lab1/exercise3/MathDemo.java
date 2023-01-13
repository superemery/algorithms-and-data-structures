import java.util.*;

public class MathDemo {
	private final static Scanner scanner = new Scanner(System.in);

	public double squareRoot(double rootIn) {
		return Math.sqrt(rootIn);
	}

	public void rollDice() {
		int score = (int) (Math.random() * 6) + 1;
		System.out.println("You rolled a " + score);
	}

	public void findThePower() {
		System.out.println("Enter a number you wish to raise to the power");
		double base = scanner.nextDouble();
		System.out.println("Enter the power you wish to raise the number to");
		double exponent = scanner.nextDouble();

		System.out.print("The number " + base + " raised to the power " + exponent + " = ");
		System.out.println(Math.pow(base, exponent));
	}

	public int generateLottoNumber(int maxNumber) {
		return (int) (Math.random() * maxNumber) + 1;
	}

	public int maxInteger(int num1, int num2, int num3) {
		return Math.max(Math.max(num1, num2), num3);
	}

	public void bestOfThree() {
		System.out.print("Number #1:\t");
		int num1 = scanner.nextInt();
		System.out.print("Number #2:\t");
		int num2 = scanner.nextInt();
		System.out.print("Number #3:\t");
		int num3 = scanner.nextInt();

		int maxNumber = maxInteger(num1, num2, num3);
		System.out.println("Best Number:\t" + maxNumber);
	}
}
