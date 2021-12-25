package bitmasking;

public class CountNoOfFlipBits_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A = 10, B = 20;
		System.out.println(countBitsFlip(A, B));
	}

	public static int countBitsFlip(int a, int b) {

		int z = a ^ b;
		int c = 0;
		while (z != 0) {
			c++;
			z = z & (z - 1);
		}

		return c;
	}
}
