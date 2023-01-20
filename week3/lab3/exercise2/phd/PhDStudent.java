package phd;

import student.Student;

public class PhDStudent extends Student {
	String researchArea;

	public void setResearchArea(String area) {
		researchArea = area;
	}

	public String getResearchArea() {
		return researchArea;
	}

	public void displayDetails() {
		System.out.println("Credits = " + super.credits);
		System.out.println("ID = " + super.id);
	}
}
