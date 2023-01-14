public class Test_YorDate {
	public static void main(String args[]) {
		// Create a reference to a YorDate object
		YorDate myDate = new YorDate(14, 1, 2023);

		// Using the appropriate methods set, set date1 to your birthdate
		myDate.setDay(24);
		myDate.setMonth(7);
		myDate.setYear(1989);

		// Using appropriate date1 method(s) display your birthday
		System.out.println(String.format("My birthday is: %d-%d-%d (%s)",
				myDate.getYear(), myDate.getMonth(), myDate.getDay(), myDate.getDayOfWeek()));
	}
}