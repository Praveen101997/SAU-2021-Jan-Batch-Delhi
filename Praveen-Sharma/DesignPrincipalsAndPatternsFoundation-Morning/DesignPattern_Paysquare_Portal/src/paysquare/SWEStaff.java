package paysquare;

// SWEStaff (subclass) extends Employee.
public abstract class SWEStaff extends Employee {

	// create private fields
	protected static double sal = 100000;

	// constructor of SWE Staff object
	public SWEStaff(String eN, String fN, String lN, String sex, String dN, String pN) {

		// get employee number, first name and last name from employee class
		// (super class)
		super(eN, fN, lN, sex, dN, pN, sal=100000);
	}

	@Override
	// returns a string with SWEStaff class data formatted so data could be
	// appropriately appended to a file
	public String toString2() {

		return super.toString2() + "\n" + "SWE" + "\n";
	}

	public double pay() {

		return sal;
	}

	public void printPayStub() {

		// output all info of SWE employee
		System.out.println(mainToString());
		System.out.println("TOTAL PAID AMOUNT FOR THIS MONTH: " + pay());
	}
} // end class SWEStaff
