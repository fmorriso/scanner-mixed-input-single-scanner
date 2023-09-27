import java.text.NumberFormat;
import java.util.Scanner;

public class ScannerMixedInput
{
	public static void main(String[] args)
	{
		String version = System.getProperty("java.runtime.version");
		System.out.println("java.runtime.version=" + version);

		SingleScannerWithQuirkWorkaround();
		SingleScannerWithoutQuirkWorkaround();

		System.out.println("Done");
		System.exit(0);

	}

	/**
	 * Example of using a Scanner instance to read a mix of numbers and strings
	 * while working around the "quirk" of Scanner that causes it to skip over the next input
	 * attempt if your sequence of operations is:
	 * 1. Prompt for a number (either int or double)
	 * 2. Prompt for a String
	 */
	private static void SingleScannerWithQuirkWorkaround()
	{
		System.out.format("%n%s%n",getMethodName(1));

		Scanner kb = new Scanner(System.in);

		System.out.print("What is your first name?> ");
		String firstName = kb.nextLine();

		System.out.print("How old are you?> ");
		int age = kb.nextInt();

		// WARNING: after getting a number from the keyboard and the next input is text,
		//          you need this little "trick":
		kb.nextLine();

		System.out.print("What is your last name?> ");
		String lastName = kb.nextLine();

		System.out.print("What is your weekly wage rate?> ");
		double wages = kb.nextDouble();

		NumberFormat money = NumberFormat.getCurrencyInstance();

		System.out.format("%s, %s, age %d, wages %s%n", lastName, firstName, age, money.format(wages));

		//WARNING: do NOT kb.close() because doing so will cause the next attempt to 
		//         use even a new Scanner instance to fail.
	}

	/**
	 * Another example of reading a mix of text and numbers that avoids having to deal with the "quirk" of the Scanner class.
	 * 
	 * This technique reads all input as text and converts to numbers when necessary.
	 */
	private static void SingleScannerWithoutQuirkWorkaround()
	{
		System.out.format("%n%s%n",getMethodName(1));

		Scanner kb = new Scanner(System.in);

		System.out.print("What is your first name?> ");
		String firstName = kb.nextLine();

		System.out.print("How old are you?> ");
		int age = Integer.parseInt(kb.nextLine());

		System.out.print("What is your last name?> ");
		String lastName = kb.nextLine();

		System.out.print("What is your weekly wage rate?> ");
		double wages = Double.parseDouble(kb.nextLine());

		NumberFormat money = NumberFormat.getCurrencyInstance();

		System.out.format("%s, %s, age %d, wages %s%n", lastName, firstName, age, money.format(wages));

		//WARNING: do NOT kb.close() because doing so will cause the next attempt to 
		//         use even a new Scanner instance to fail.
	}

	/**
	 * Get the method name for a depth in call stack. <br />
	 * Utility function
	 * @param depth depth in the call stack (0 means current method, 1 means call method, ...)
	 * @return method name
	 */
	public static String getMethodName(final int depth)
	{
		final StackTraceElement[] ste = Thread.currentThread().getStackTrace();

		//System. out.println(ste[ste.length-depth].getClassName()+"#"+ste[ste.length-depth].getMethodName());
		// return ste[ste.length - depth].getMethodName();  //Wrong, fails for depth = 0
		return ste[ste.length - 1 - depth].getMethodName(); //Thank you Tom Tresansky
	}
}
