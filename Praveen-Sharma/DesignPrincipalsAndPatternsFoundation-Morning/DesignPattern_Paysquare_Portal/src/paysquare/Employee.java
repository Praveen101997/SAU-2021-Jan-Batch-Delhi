package paysquare;

// Employee abstract superclass
public abstract class Employee {

	// create protected fields
	protected String employeeNumber;
	protected String firstName;
	protected String lastName;
	protected String sex;
	protected String designation;
	protected double salary;
	protected String paymentNotification;

	// constructor (initializes all fields of the Employee object)
	public Employee(String eN, String fN, String lN, String sex, String dN, String pN, double sL) {
		this.employeeNumber = eN;
		this.firstName = fN;
		this.lastName = lN;
		this.sex = sex;
		this.designation = dN;
		this.paymentNotification = pN;
		this.salary = sL;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getPaymentNotification() {
		return paymentNotification;
	}

	public void setPaymentNotification(String paymentNotification) {
		this.paymentNotification = paymentNotification;
	}

	// return first name
	public String getFirstName() {
		return firstName;
	}

	// return last name
	public String getLastName() {
		return lastName;
	}

	// return social security number
	public String getEmployeeNumber() {
		return employeeNumber;
	}

	// returns a string with employee class data printed out nicely for user to
	// see
	public String mainToString() {

		return "Employee Number: " + getEmployeeNumber() + "\n" + "First Name: " + getFirstName() + "\n" + "Last Name: "
				+ getLastName() + "\n" + "Sex: " + getSex() + "\n" + "Designation: " + getDesignation() + "\n"
				+ "Salary: " + getSalary() + "\n";
	}

	// returns a string with employee class data formatted so data could be
	// appropriately appended into a file
	public String toString2() {

		return getEmployeeNumber() + "\n" + getFirstName() + "\n" + getLastName();
	}

	/** abstract method overridden by subclasses **/

	// pay an abstract method that returns an employee's pay
	public abstract double pay(); // NO PARAMS; RETURNS DOUBLE. BY DEFINING
									// pay()ABSTRACTLY HERE IN STAFFMEMBER, THE
									// payday METHOD OF STAFF CAN
									// POLYMORPHICALLY PAY EACH EMPLOYEE.

	// printPayStub an abstract method that prints
	// (display on screen) the monthly pay stub of an employee
	public abstract void printPayStub();

} // end abstract class Employee
