import java.util.*;

public class KlingonShip {
	private double photonPower = 45;
	private int threatFactor = 7;
	private double cosmicProximity = 20.6;

	public void displayKlingonDetails() {
		System.out.println("Photon Power:\t\t" + photonPower);
		System.out.println("Threat Factor:\t\t" + threatFactor);
		System.out.println("Cosmic Proximity:\t" + cosmicProximity);
		System.out.println("Danger Level:\t\t" + getDangerLevel());
	}

	public double getDangerLevel() {
		double dangerLevel = (photonPower * threatFactor) / cosmicProximity;
		return dangerLevel;
	}

	public void promptSettings() {
		System.out.println("-------- Settings Start --------");

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Photon Power:\t\t");
			photonPower = scanner.nextDouble();
			System.out.print("Threat Factor:\t\t");
			threatFactor = scanner.nextInt();
			System.out.print("Cosmic Proximity:\t");
			cosmicProximity = scanner.nextDouble();
		}

		System.out.println("--------   New Details  --------");
		displayKlingonDetails();
	}
}
