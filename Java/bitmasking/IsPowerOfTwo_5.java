package bitmasking;

public class IsPowerOfTwo_5 {

	public static void main(String[] args) {
        System.out.println(isPowerofTwo(98));
	}

	public static boolean isPowerofTwo(long n) {
		if (n == 0) {
			return false;
		}

		return ((n & (n - 1)) == 0 ? true : false);

	}
	
    public boolean isPowerOfTwo(int n) {
        if(n == 1)
            return true;
        if(n%2 != 0 || n == 0)
            return false;
        if(isPowerOfTwo(n/2))
            return true;
        return false;
    }

}
