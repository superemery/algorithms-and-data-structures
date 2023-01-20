package student;

public class Student {
	private String name;
	protected String id;
	protected int credits;

	public void setName(String nameIn) {
		name = nameIn;
	}

	public void setID(String idIn) {
		id = idIn;
	}

	public void setCredits(int creditsIn) {
		credits = creditsIn;
	}

	public String getName() {
		return name;
	}

	public void changeName(String replacementName) {
		name = replacementName;
	}

	public String getStudentID() {
		return id;
	}

	public void addCredits(int additionalPoints) {
		credits += additionalPoints;
	}

	public int getCredits() {
		return credits;
	}

	public void printDetails() {
		System.out.println(name + " (" + id + ")");
		System.out.println("Credits = " + credits);
	}

	public void incCredits(int increase) {
		credits += increase;
	}
}
