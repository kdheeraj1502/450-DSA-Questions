package bitmasking;

public class DivideWithoutOperator_8 {

	public static void main(String[] args) {

		division1(10, 3);

	}

	// method -1 subtraction a/b
	public static void division1(int a, int b) {

		int q = 0;
		while (a >= b) {
			a = a - b;
			q++;
		}
		// quotient
		System.out.println(q);
		// remainder
		System.out.println(a);
	}
	
	

}
