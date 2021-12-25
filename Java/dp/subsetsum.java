package dp;

import java.util.*;

public class subsetsum {

	int[][] dp;
	int sum;

	subsetsum(int num[], int sum) {
		this.dp = new int[num.length + 1][sum + 1];
		this.sum = sum;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 2, 7, 1, 3 };
		subsetsum ss = new subsetsum(arr, 10);
		 // 7, 3 // 7, 2 , 1 // 4, 2, 3, 1 // ===== count
		// ss.subsetsum(arr);
		System.out.println("------------------------");
		ss.subsetsum_self(arr);
		System.out.println("------------");
		ss.subsetsum_count(arr);
	}

	public void subsetsum_count(int[] num) {
		int dp[][] = new int[num.length + 1][sum + 1];

		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = 1;
			for (int j = 1; j < dp[i].length; j++) {
				if (num[i - 1] == j) {
					dp[i][j] = 1;
				}
			}
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if (num[i - 1] >= j) {
					if (num[i - 1] == j)
						dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num[i - 1]];
				}
			}
		}
		System.out.println(dp[dp.length - 1][sum]);
	}

	public void subsetsum_self(int[] num) {
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (dp[i - 1][j] == 1)
					dp[i][j] = dp[i - 1][j];
				else {
					int val = num[i - 1];
					if (j >= val && dp[i - 1][j - val] == 1) {
						dp[i][j] = dp[i - 1][j - val];
					}
				}
			}
		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("----------subset -----------");
		printSet_self(num);
	}
	
	private void printSet_self(int num[]) {
		int i = dp.length - 1;
		int j = sum;
		int min = dp[i][j];
		while(j > 0) {
			if(dp[i - 1][j] == min) {
				i = i - 1;
			} else {
				System.out.print(num[i - 1] + ", ");
				j = j - num[i - 1];
				min = dp[i][j];
			}
		}
		System.out.println();
		System.out.println("----------subset -----------");
	}
	
	private void printSet(int num[]) {
		int i = dp.length - 1;
		int j = sum;
		int min = dp[i][j];
		while (j > 0) {
			System.out.println("i is " + i + " j is " + j);
			if (dp[i - 1][j] == min) {
				i = i - 1;
			} else {
				System.out.print(num[i - 1] + ", ");
				j = j - num[i - 1];
				min = dp[i][j];
			}
		}
		System.out.println();
		System.out.println("----------subset -----------");
	}

	public void subsetsum(int[] arr) {
		int[][] dp = new int[arr.length + 1][sum + 1];
		dp[1][arr[0]] = 1;
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}
		for (int i = 2; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (dp[i - 1][j] == 1) {
					dp[i][j] = dp[i - 1][j];
				} else if (j - arr[i - 1] >= 0 && dp[i - 1][j - arr[i - 1]] == 1) {
					dp[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

	}

}

class Pair {
	int index;
	int target;
	String result;

	Pair(int index, int target, String result) {
		this.index = index;
		this.target = target;
		this.result = result;
	}
}
