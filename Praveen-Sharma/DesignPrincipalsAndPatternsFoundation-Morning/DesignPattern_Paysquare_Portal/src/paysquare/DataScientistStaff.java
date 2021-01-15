package paysquare;

// DataScientistStaff (subclass) extends Employee.
public abstract class DataScientistStaff extends Employee {

	// create private fields
	protected static double sal = 75000;

	// constructor of Data Scientist Staff object
	public DataScientistStaff(String eN, String fN, String lN, String sex, String dN, String pN) {

		// get employee number, first name and last name from employee class
		// (super class)
		super(eN, fN, lN, sex, dN, pN, sal = 75000);
	}

	@Override
	// returns a string with DataScientistStaff class data formatted so data
	// could be
	// appropriately appended to a file
	public String toString2() {

		return super.toString2() + "\n" + "Data Scientist" + "\n";
	}

	public double pay() {
		return sal;
	}

	public void printPayStub() {

		// output all info of data scientist
		System.out.println(mainToString());
		System.out.println("TOTAL PAID AMOUNT FOR THIS MONTH: " + pay());
	}
} // end class DataScientistStaff
