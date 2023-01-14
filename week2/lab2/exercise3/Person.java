public class Person {
	private static final int RWAL = 21; // RWAL - Recommended Weekly Alcohol Limit
	private double cmHeight;
	private double kgWeight;
	private boolean smoker = true;
	private int weeklyAlcholUnits; // 1 pint = 2 units, 1 short = 1 unit)
	private int restPulse;
	private YorDate dateOfBirth;
	private String name;

	public Person(String name, int day, int month, int year) {
		this.name = name;
		dateOfBirth = new YorDate();
		dateOfBirth.setDay(day);
		dateOfBirth.setMonth(month);
		dateOfBirth.setYear(year);
	}

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
		System.out.println("Name:\t\t" + name);
		System.out.println("Date of Birth:\t" + dateOfBirth);
		System.out.println("Height (cm):\t" + cmHeight);
		System.out.println("Weight (kg):\t" + kgWeight);
		System.out.println("Healthy Pulse:\t" + checkPulse());
		System.out.println("Abusing Body:\t" + checkAbuser());
	}
}
