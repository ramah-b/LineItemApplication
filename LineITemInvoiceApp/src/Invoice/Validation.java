package Invoice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validation {

	public static String getString(Scanner sc, String prompt) {
		System.out.print(prompt);
		String s = sc.next(); // read user entry
		sc.nextLine(); // discard any other data entered on the line
		return s;
	}

	public static int getInt(Scanner sc, String prompt) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			
				try {
					i = sc.nextInt();
					isValid = true;
				} catch (InputMismatchException e) {
					System.out
							.println("Incorrect input. Please enter a valid integer.");
				}
			
			sc.nextLine(); // discard any other data entered on the line
		}

		return i;
	}

	public static double getDouble(Scanner sc, String prompt) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			try{
				d = sc.nextDouble();
				isValid = true;
			} catch(InputMismatchException e){
				System.out
				.println("Incorrect input. Please enter a valid number.");
	}finally{
		System.out.println("This is a finally clause.");
	}

				
			sc.nextLine(); // discard any other data entered on the line
		}
		return d;
	}

	
	public static boolean getBoolean(Scanner sc, String prompt) {
		boolean b = false;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			try{
				b = sc.nextBoolean();
				isValid = true;
			} catch(InputMismatchException e){
				System.out
				.println("Incorrect input. Please enter TRUE or FALSE.");
	}

				
			sc.nextLine(); // discard any other data entered on the line
		}
		return b;
	}
}
