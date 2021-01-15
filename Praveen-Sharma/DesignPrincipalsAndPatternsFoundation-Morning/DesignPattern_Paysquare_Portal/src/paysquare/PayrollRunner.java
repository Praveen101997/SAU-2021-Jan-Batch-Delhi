package paysquare;

import java.util.Scanner;

public class PayrollRunner {

	// variable to loop printing menu
	static int x = 0;

	public static void main(String[] args) {

		// instantiate payroll class
		Payroll pr = new Payroll();

//		Runnable r = new Runnable() {
//			public void run() {
//				pr.payAllEmployees();
//			}
//		};
//
//		new Thread(r).start();

		Runnable r = new Runnable() {
			public void run() {
				boolean flag = true;	
				while(flag){
					pr.payAllEmployees();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread t = new Thread(r);
		// Lets run Thread in background..
		// Sometimes you need to run thread in background for your Timer application..
		t.start(); // starts thread in background..
		
		// loop printing menu
		while (x == 0) {

			// output menu
			System.out.println("LOAD                loads information from file\n"
					+ "PRINT               prints pay stubs for all employees\n"
					+ "LIST                lists information for all employees\n"
					+ "PAY              	 pay employees for current month\n"
					+ "MENU                prints program menu again\n" + "EXIT                quits program");

			int y = 0; // variable for 2nd loop

			// loop getting input
			while (y == 0) {

				// get input
				Scanner scan = new Scanner(System.in);

				// return input into string
				String input = scan.nextLine();

				System.out.println(">");

				// check user's input
				switch (input.toUpperCase()) {

				// breaks loop to print menu
				case "MENU":

					y = 1;
					break;

				// loads a file with employee data
				case "LOAD":

					// get file name from user

					Scanner fileName = new Scanner(System.in);

					System.out.println("ENTER NAME OF FILE (INCLUDE ANY EXTENSIONS): ");

					String filename = scan.nextLine();

					// give file name as a string to the load method
					pr.loadStaffList(filename);
					System.out.println("File Loaded Successfully");
					break;

				// print pay stubs
				case "PRINT":

					pr.printAllPayStubs();
					break;

				// list all employee class data
				case "LIST":

					pr.listAllEmployees();
					break;

				case "PAY":
					pr.payAllEmployees();
					break;

				// exit program
				case "EXIT":

					System.exit(0);

					// if none
					// print friendly message
				default:
					System.out.println("INVALID COMMAND!");
					break;
				}
			}
		}
	}
}