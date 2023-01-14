import java.util.Scanner;

public class WrappedUp {
	private static final Scanner SCANNER = new Scanner(System.in);

	public void guessMyFavouriteThing() {
		final String favAnimal = "sheep";

		System.out.println(
				"Guess my favourite animal. It has " + favAnimal.length() +
						" characters and begins with " + favAnimal.charAt(0) + ".");

		String ans = SCANNER.nextLine();
		System.out.println(ans.equalsIgnoreCase(favAnimal) ? "Correct!" : "Wrong!");
	}

	public static void main(String args[]) {
		WrappedUp wrappedUp = new WrappedUp();
		wrappedUp.guessMyFavouriteThing();
	}
}
