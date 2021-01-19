package JavaFundamental;

public class throw_arithmetic_exception_using_throws {

	public static void main(String[] args) {
		int a = 100;
		int b = 4;
		int c = 8;
		
		System.out.println("a : "+a);
		System.out.println("b : "+b);
		System.out.println("c : "+c);
		
		System.out.println("--------------------------------");
		
		try{
			int res = a/b;
			System.out.println(res);
		}catch (ArithmeticException e) {
			System.out.println("Exception caught : "+e);
		}
		
		
		System.out.println("--------------------------------");
		
		try{
			int res = a/(2*b-c);
			System.out.println(res);
		}catch (ArithmeticException e) {
			System.out.println("Exception caught : "+e);
		}
		
	}

}
