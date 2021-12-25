package bitmasking;

import java.util.Arrays;

public class FindTwoNonRepeatingNumbers_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 4, 3 };
		missingno(5, arr);
		int z = 8;
		System.out.println(5 & -5);
		int a = z & ~(z - 1);

		System.out.println("a is " + a);

		int num[] = {1, 2, 3, 2, 1, 4};
		System.out.println(Arrays.toString(singleNumber(num)));
	}

	public static int[] singleNumber(int[] nums) {
		int xor = 0;
		for(int val : nums){
			xor ^= val;
		}
		int rsbm = xor & ~(xor - 1);
		int a = 0;
		int b = 0;
		int result[] = new int[2];
		for(int val : nums){
			if((val & rsbm) == 0){
				a ^= val;
			} else{
				b ^= val;
			}
		}
		if(a < b){
			result[0] = a;
			result[1] = b;
		}
		else{
			result[1] = a;
			result[0] = b;
		}
		return result;
	}

	public static void missingno(int n, int[] arr) {

		int z = 1;
		for (int i = 2; i <= n; i++) {
			z = z ^ i;
		}

		for (int i = 0; i < arr.length; i++) {
			z = z ^ arr[i];
		}

		// now z contains xor of two missing no
//		System.out.println(z);

		int rightmostsetbit = z & ~(z - 1);

		int set = 0, reset = 0;
		for (int i = 1; i <= n; i++) {
			if ((i & rightmostsetbit) != 0) {
				set = set ^ i;
			} else {
				reset = reset ^ i;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & rightmostsetbit) != 0) {
				set = set ^ arr[i];
			} else {
				reset = reset ^ arr[i];
			}
		}

		System.out.println("missing no are -> " + set + " , " + reset);

	}

}
