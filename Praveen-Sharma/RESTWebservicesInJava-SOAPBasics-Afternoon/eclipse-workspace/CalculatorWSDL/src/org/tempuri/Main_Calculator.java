package org.tempuri;

public class Main_Calculator {

	public static void main(String[] args) {
		int a = 88;
		int b = 4;

		Calculator cal = new Calculator();
		CalculatorSoap soap = cal.getCalculatorSoap();

		int sum = soap.add(a, b);
		System.out.println("Sum : " + sum);

		int sub = soap.subtract(a, b);
		System.out.println("Sub : " + sub);

		int div = soap.divide(a, b);
		System.out.println("Div : " + div);

		int mul = soap.multiply(a, b);
		System.out.println("Mul : " + mul);

	}

}
