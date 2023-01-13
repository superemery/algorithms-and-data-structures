import java.util.*;

public class Person {
	private final int RWAL = 21; // RWAL - Recommended Weekly Alcohol Limit
	private double cmHeight;
	private double kgWeight;
	private boolean smoker = true;
	private int weeklyAlcholUnits; // 1 pint = 2 units, 1 short = 1 unit)
	private int restPulse;

	public void setHeight(double heightIn) {
		cmHeight = heightIn;
	}

	public void setWeight(double weightIn) {
		kgWeight = weightIn;
	}

	public void setPulse(int pulseIn) {
		restPulse = pulseIn;
	}

	public boolean checkPulse() {
		boolean healthyPulse = restPulse > 30 && restPulse < 180;

		return healthyPulse;
	}

	public boolean checkAbuser() {
		boolean abuser = weeklyAlcholUnits > RWAL || smoker;

		return abuser;
	}

	public void displayProfile() {
		System.out.println("-------- Health Profile --------");
		System.out.println("Healthy Plse Check:\t" + checkPulse());
		System.out.println("Abusing Body:\t\t" + checkAbuser());
		System.out.println("BMI:\t\t\t" + getBMI());
	}

	public void promptSettings() {
		System.out.println("-------- Settings Start --------");

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Height (cm):\t\t");
			cmHeight = scanner.nextDouble();
			System.out.print("Weight (kg):\t\t");
			kgWeight = scanner.nextDouble();
			System.out.print("Weekly Alchol Units:\t");
			weeklyAlcholUnits = scanner.nextInt();
			System.out.print("Rest Pulse:\t\t");
			restPulse = scanner.nextInt();
		}

		displayProfile();
	}

	public double getBMI() {
		double bmi = 10000 * kgWeight / (cmHeight * cmHeight);

		return bmi;
	}
}
