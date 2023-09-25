import java.text.NumberFormat;
import java.util.Scanner;

public class ScannerMixedInput {
	public static void main(String[] args)
	{
		// uncomment ONLY ONE of the following two lines:
		SingleScannerWithQuirkWorkaround();
		// SingleScannerWithoutQuirkWorkaround();
	}

	/**
	 * Example of using a Scanner instance to read a mix of numbers 
	 * and strings while working around the "quirk" of Scanner that causes
	 * it to skip over the next input attempt if your sequence of operations
	 * is:
	 * 1. Prompt for a number (either int or double)
	 * 2. Prompt for a String
	 */
	private static void SingleScannerWithQuirkWorkaround()
	{
		Scanner kb = new Scanner(System.in);

		System.out.println("What is your first name?");
		String firstName = kb.nextLine();

		System.out.println("How old are you?");
		int age = kb.nextInt();

		// WARNING: after getting a number and the next input is text, 
		//          you need this little "trick":
		kb.nextLine();

		System.out.println("What is your last name?");
		String lastName = kb.nextLine();

		System.out.println("What is your weekly wage rate?");
		double wages = kb.nextDouble();

		NumberFormat money = NumberFormat.getCurrencyInstance();

		System.out.format("%s, %s, age %d, wages %s", lastName, firstName, age, money.format(wages));

		kb.reset();

	}

	/**
	 * Another example of reading a mix of text and numbers that avoids having
	 * to deal with the "quirk" of the Scanner class.
	 * 
	 * This technique reads all input as text and converts to numbers when necessary.
	 */
	private static void SingleScannerWithoutQuirkWorkaround()
	{
		Scanner kb = new Scanner(System.in);

		System.out.println("What is your first name?");
		String firstName = kb.nextLine();

		System.out.println("How old are you?");
		int age = Integer.parseInt(kb.nextLine());

		System.out.println("What is your last name?");
		String lastName = kb.nextLine();

		System.out.println("What is your weekly wage rate?");
		double wages = Double.parseDouble(kb.nextLine());

		NumberFormat money = NumberFormat.getCurrencyInstance();

		System.out.format("%s, %s, age %d, wages %s", lastName, firstName, age, money.format(wages));
		kb.close();
	}
}
