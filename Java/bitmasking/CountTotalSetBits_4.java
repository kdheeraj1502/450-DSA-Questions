package bitmasking;

public class CountTotalSetBits_4 {

	public static void main(String[] args) {
		int num = 40;
		System.out.println(countSetBits(num));
	}

	public static int countSetBits(int n) {
		if (n == 0) {
			return 0;
		}
		int x = maxPowerOf2(n);
		return (x << (x - 1)) + (n + 1 - (1 << x)) + countSetBits(n - (1 << x));
	}

	public static int maxPowerOf2(int n) {
		int x = 0;
		while ((1 << x) <= n) {
			x++;
		}
		return x - 1;
	}
}
