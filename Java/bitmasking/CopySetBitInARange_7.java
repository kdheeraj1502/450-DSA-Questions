package bitmasking;

public class CopySetBitInARange_7 {

	public static void main(String[] args) {

		System.out.println(copybits(13, 10, 2, 3));
	}

	// a -> b copy set bits in range
	public static int copybits(int a, int b, int l, int r) {

		int m1 = 1;
		m1 = m1 << (r - l + 1);
		m1 = m1 - 1;
		m1 = m1 << (l - 1);

		int actualmask = a & m1;
		return b | actualmask;

	}

}
