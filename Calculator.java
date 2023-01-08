import java.util.Scanner;
import java.awt.*;
import java.util.*;
import java.text.*;

//parent class
class AddSub {
	double z;

	public void addition(double x, double y) {
		z = x + y;
		System.out.println("The sum of the given numbers: " + z);
	}

	public void Subtraction(double x, double y) {
		z = x - y;
		System.out.println("The difference between the given numbers: " + z);
	}
}

//child class
class MulDiv extends AddSub {
	public void multiplication(double x, double y) {
		z = x * y;
		System.out.println("The product of the given numbers: " + z);
	}

	public void division(double x, double y) {
		z = x / y;
		System.out.println("The division of the given numbers: " + z);
	}

}

public class Calculator {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int choice = -1;
		while (choice != 0) {

			System.out.println("Enter the choice\n");
			System.out.println("1.Calculator");
			System.out.println("2.Currency converter USD to INR");
			System.out.println("3.Weight lb to kg");
			System.out.println("4.Distance miles to km");
			System.out.println("5.temperature f to c");
			System.out.println("6.Calculate mileage miles per hour");
			System.out.println("7.Get Central Standard Time And Date Or Indian Standard Time And Date");
			System.out.println("8.Convert Liters to Gallons.");
// 			System.out.println("9.");
			System.out.println("0.Exit");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				calculator();
				break;
			case 2:
				currencyConverter();
				break;
			case 3:
				weightConverter();
				break;
			case 4:
				distanceConverter();
				break;
			case 5:
				temperatureConverter();
				break;
			case 6:
				calculateMileage();
				break;
			case 7:
				getTime();
				break;
			case 8:
				convertLitersToGallons();
				break;
			case 9:
				// add function
				break;
			case 0:
				break;
			default:
				System.out.println("Please enter the correct choice");
			}
		}
		System.out.println("Exited!\nBye!");
	}

	// case 1
	private static void calculator() {
		while (true) {
			System.out.println("Enter the operation(+,-,*,/) or 0 to exit");
			char choice = scan.next().charAt(0);

			if (choice == '0') {
				return;
			}
			MulDiv instance = new MulDiv();// object
			System.out.println("Enter First number");
			double first = scan.nextDouble();
			System.out.println("Enter Second number");
			double second = scan.nextDouble();
			switch (choice) {
			case '+':
				instance.addition(first, second);
				break;
			case '-':
				instance.Subtraction(first, second);
				break;
			case '*':
				instance.multiplication(first, second);
				break;
			case '/':
				instance.division(first, second);
				break;
			case '0':
				// return;
				break;
			default:
				System.out.println("Please enter the correct choice");
			}
		}
	}

	// case 2
	private static void currencyConverter() {
		System.out.println("Enter currency in USD");
		double dollar = scan.nextDouble();
		double constant = 80.00;
		System.out.println(+dollar + " Dollar : " + dollar * constant + " Rupees");
	}

	// case 3
	private static void weightConverter() {
		System.out.println("Enter weight in pounds");
		double pound = scan.nextDouble();
		System.out.println(+pound + " Pounds : " + pound * 0.4535 + " Kgs");
	}

	// case 4
	private static void distanceConverter() {
		System.out.println("Enter distance in miles");
		double miles = scan.nextDouble();
		System.out.println(+miles + " Miles : " + miles * 1.609 + " Kms");
	}

	// case 5
	private static void temperatureConverter() {
		System.out.println("Enter temperature in farenheit");
		double farenheit = scan.nextDouble();
		System.out.println(+farenheit + " Farenheits : " + (farenheit - 32) * 5 / 9 + " Celsius");
	}

	// case 6
	private static void calculateMileage() {
		System.out.println("Current Odometer Reading");
		int curr = scan.nextInt();
		System.out.println("Prev Odometer Reading");
		int prev = scan.nextInt();
		System.out.println("Gas Added to the Tank (Gallons)");
		int gallonsAdded = scan.nextInt();

		System.out.println("Mileage is  " + (curr - prev) / gallonsAdded + "mpg.");
	}

// 	// case 7

	public static void getTime() {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss z");
		Date date = new Date();
		System.out.println("Enter Time Zone (CST or IST): ");
		Scanner sc = new Scanner(System.in);
		String timeZone = sc.nextLine();
		if (timeZone.equals("CST")) {
			sd.setTimeZone(TimeZone.getTimeZone("CST"));
			System.out.println("Central Standard Date And Time: " + sd.format(date));
		} else if (timeZone.equals("IST")) {
			sd.setTimeZone(TimeZone.getTimeZone("IST"));
			System.out.println("Indian Standard Date And Time: " + sd.format(date));
		} else {
			System.out.println("You have entered invalid option. ");
		}

	}

	// Case 8
	private static void convertLitersToGallons() {
		System.out.println("Liters: ");
		double liters = scan.nextDouble();

		System.out.println(liters + " Liters is equal to " + liters * 0.264172 + " Gallons.");

	}
}
