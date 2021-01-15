package paysquare;

// HRStaff (subclass) extends Employee.
public abstract class HRStaff extends Employee {

	// create private fields
	protected static double sal = 50000;

	// constructor of HR Staff object
	public HRStaff(String eN, String fN, String lN, String sex, String dN, String pN) {

		// get employee number, first name and last name from employee class
		// (super class)
		super(eN, fN, lN, sex, dN, pN, sal = 50000);
	}

	@Override
	// returns a string with HRStaff class data formatted so data could be
	// appropriately appended to a file
	public String toString2() {

		return super.toString2() + "\n" + "HR" + "\n";
	}

	public double pay() {
		return sal;
	}

	public void printPayStub() {

		// output all info of HR employee
		System.out.println(mainToString());
		System.out.println("TOTAL PAID AMOUNT FOR THIS MONTH: " + pay());
	}
} // end class HRStaff
