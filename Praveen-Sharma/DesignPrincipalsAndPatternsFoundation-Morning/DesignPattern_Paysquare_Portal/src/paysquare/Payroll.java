package paysquare;

import java.util.ArrayList;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

// Payroll class, which store the list of employee
public class Payroll {

	/** create the variables needed for the methods of payroll **/

	// create an array list for storing employee objects
	ArrayList<Employee> staffList = new ArrayList();

	// create an array for storing file lines
	ArrayList<String> ar = new ArrayList<>();

	// other variables
	BufferedReader fileIn;
	PrintWriter pw = null;
	Boolean beginning = true;
	int num_of_employees, staffIndex;
	SWEStaff fts;
	HRStaff pts;
	DataScientistStaff dts;
	String strLine, employeeNumber, firstName, lastName, employeeType, sex, designation, salary, paymentNotification;

	// lists all employee (employee number, name)
	public void payAllEmployees() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		int tday = date.getDate();
		int tmonth = date.getMonth();
		int hr = date.getHours();
		int min = date.getMinutes();
		int sec = date.getSeconds();
		String mon = "";
		// System.out.println(hr+" "+min+" "+sec);
		switch (tmonth) {
		case 0:
			mon = "January";
			break;
		case 1:
			mon = "February";
			break;
		case 2:
			mon = "March";
			break;
		case 3:
			mon = "April";
			break;
		case 4:
			mon = "May";
			break;
		case 5:
			mon = "June";
			break;
		case 6:
			mon = "July";
			break;
		case 7:
			mon = "August";
			break;
		case 8:
			mon = "September";
			break;
		case 9:
			mon = "October";
			break;
		case 10:
			mon = "November";
			break;
		case 11:
			mon = "December";
			break;

		default:
			break;
		}

		if (tday == 15 && hr == 15 && min == 0 && sec == 0) {
			// for each employee object in staff list
			for (int i = 0; i < staffList.size(); i++) {
				// output the 'main to string' method from employee class
				// with the data of the employee
				String fname = staffList.get(i).getFirstName();
				String lname = staffList.get(i).getLastName();
				int month = tmonth;
				int day = tday;
				String nC = staffList.get(i).getPaymentNotification();

				System.out.println("Payment is successfully Done of " + fname + " " + lname + " of " + mon + ".");
				notificationSend(staffList, i);
				System.out.println("----------------------------------------------------------------------");
			}

		}
		// else {
		// System.out.println("Payment will only done on 15th of months");
		// }

	}

	private void notificationSend(ArrayList<Employee> staffList, int i) {
		if (staffList.get(i).getPaymentNotification().equals("SMS")) {
			System.out.println("Notification Sended Successfully on registered mobile no via "
					+ staffList.get(i).paymentNotification + " successfully");
		} else if (staffList.get(i).getPaymentNotification().equals("Email")) {
			System.out.println("Notification Sended Successfully on registered Email Id successfully");
		} else {
			System.out.println("Notification Sended Successfully via push notification successfully");
		}
	}

	// lists all employee (employee number, name)
	public void listAllEmployees() {

		// for each employee object in staff list
		for (int i = 0; i < staffList.size(); i++) {
			// output the 'main to string' method from employee class
			// with the data of the employee
			System.out.println(staffList.get(i).mainToString());

			if (staffList.get(i) instanceof SWEStaff) {
				System.out.println("TITLE: Software Engineer\n");
			} else if (staffList.get(i) instanceof HRStaff) {
				System.out.println("TITLE: HR\n");
			} else if (staffList.get(i) instanceof DataScientistStaff) {
				System.out.println("TITLE: Data Scientist\n");
			}
		}
	}

	// prints on screen the pay stub (for the currently month) for all employees
	public void printAllPayStubs() {

		// loop through employees
		for (int i = 0; i < staffList.size(); i++) {
			/**
			 * get employee type call 'pay stub printing' methods of the
			 * employee object to output the pay stubs
			 **/
			if (staffList.get(i) instanceof SWEStaff) {

				staffList.get(i).printPayStub();

			} else if (staffList.get(i) instanceof HRStaff) {
				staffList.get(i).printPayStub();
			} else if (staffList.get(i) instanceof DataScientistStaff) {
				staffList.get(i).printPayStub();
			}

			// seperate each pay stubs from each other nicely
			System.out.println("\n-----------------------");
		}
	}

	// loads employee information from the specified file
	public void loadStaffList(String filename) {

		// variable to hold count for the lines of each employee in file
		int lineCount = 0;

		try {

			// create a BufferedReader object using the FileReader constructor
			// with the filename given by user
			fileIn = new BufferedReader(new FileReader(filename));

			// loop reading every line of the file until the line is empty
			while ((strLine = fileIn.readLine()) != null) {

				// store the number of employees given at the beginning of the
				// file in a variable for payroll access
				if (beginning == true) {

					num_of_employees = Integer.parseInt(strLine);
					beginning = false;

				} else {

					// if line number is lower than 6
					if (lineCount < 6) {

						// add the line read into an array and add 1 to line
						// count
						ar.add(strLine);
						lineCount++;

					}

					// if line count has reached 6
					if (lineCount == 6) {

						/**
						 * get each string at every index of the array and store
						 * value into its appropriate variable
						 **/

						employeeNumber = ar.get(0);
						firstName = ar.get(1);
						lastName = ar.get(2);
						sex = ar.get(3);
						designation = ar.get(4);
						paymentNotification = ar.get(5);

						// if employee type from line 4 is full time
						if (designation.equals("SWE")) {

							// create a full time object with the created
							// variables
							fts = new SWEStaff(employeeNumber, firstName, lastName, sex, designation,
									paymentNotification) {
							};

							// add full time object to staff list
							staffList.add(fts);

							// if employee type from line 4 is part time
						} else if (designation.equals("HR")) {

							// create a part time object with the variables
							pts = new HRStaff(employeeNumber, firstName, lastName, sex, designation,
									paymentNotification) {
							};

							// add part time object to staff list
							staffList.add(pts);
						} else {

							// create a part time object with the variables
							dts = new DataScientistStaff(employeeNumber, firstName, lastName, sex, designation,
									paymentNotification) {
							};

							// add part time object to staff list
							staffList.add(dts);
						}

						// return line count to zero
						lineCount = 0;

						// reset array
						ar.clear();

					}
				}
			}

		} catch (IOException | NumberFormatException e) {// Catch exception if
															// any error
			System.err.println("Error: " + e.getMessage());
		}
	}
}
