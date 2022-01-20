package strings;

import java.util.*;

public class CountPallindromicSubsequence_22 {

	public static void main(String[] args) {
		String str = "bccb";
		System.out.println(subsequenceoptimised(str));
		// System.out.println(countPS(str));
		//System.out.println(Math.pow(10, 9));
		
		System.out.println(countPalindromicSubsequences("bcb"));
	}

	public static long subsequenceoptimised(String str) {

		int dp[][] = new int[str.length()][str.length()];
		// gap
		int g = 0;
		int i = 0;
		int j = g;
		for (g = 0; g < dp.length; g++) {
			for (i = 0, j = g; i < dp.length && j < dp.length; i++, j++) {
				// if gap ==0
				if (g == 0) {
					dp[i][j] = 1;
				} else if (g == 1) {
					if (str.charAt(i) == str.charAt(j)) {
						dp[i][j] = 3;
					} else {
						dp[i][j] = 2;
					}
				} else {
					if (str.charAt(i) == str.charAt(j)) {
						dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
					} else {
						dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
					}

				}
			}
		}

		return (long) ((dp[0][str.length() - 1]) % (Math.pow(10, 9) + 7));

	}

	static int countPS(String str) {
		int N = str.length();
		int[][] cps = new int[N][N];
		for (int i = 0; i < N; i++)
			cps[i][i] = 1;
		for (int L = 2; L <= N; L++) {
			for (int i = 0; i <= N - L; i++) {
				int k = L + i - 1;
				if (str.charAt(i) == str.charAt(k)) {
					cps[i][k] = (cps[i][k - 1] + cps[i + 1][k] + 1) % (10 ^ 9 + 7);
				} else {
					cps[i][k] = cps[i][k - 1] + cps[i + 1][k] - cps[i + 1][k - 1];
				}
			}
		}
		return cps[0][N - 1];
	}

	public static int sol(String s, int l, int r) {
		if (r < l)
			return 0;
		if (l == r)
			return 1;

		int ans = 0;
		if (s.charAt(l) == s.charAt(r)) {
			ans = 1 + sol(s, l + 1, r) + sol(s, l, r - 1) - sol(s, l + 1, r - 1);
		} else {
			ans = sol(s, l + 1, r) + sol(s, l, r - 1) - sol(s, l + 1, r - 1);
		}

		return ans;
	}

	static public int countPalindromicSubsequences(String str) {
		int[] pre = new int[str.length()];
		HashMap<Character, Integer> map = new HashMap<>();
		int mod = 1000000007;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (map.containsKey(ch))
				pre[i] = map.get(ch);
			else
				pre[i] = -1;
			map.put(ch, i);
		}

		int[] next = new int[str.length()];
		map = new HashMap<>();
		for (int i = str.length() - 1; i >= 0; i--) {
			char ch = str.charAt(i);
			if (map.containsKey(ch))
				next[i] = map.get(ch);
			else
				next[i] = Integer.MAX_VALUE;
			map.put(ch, i);
		}

		int[][] dp = new int[str.length()][str.length()];

		for (int g = 0; g < dp.length; g++) {
			for (int i = 0, j = g; j < dp[0].length; i++, j++) {
				if (g == 0)
					dp[i][j] = 1;
				else if (g == 1)
					dp[i][j] = 2;
				else {
					if (str.charAt(i) == str.charAt(j)) {
						int n = next[i];
						int p = pre[j];
						if (n > p)
							dp[i][j] = ((2 * dp[i + 1][j - 1]) + 2) % mod;
						else if (n == p)
							dp[i][j] = ((2 * dp[i + 1][j - 1]) + 1) % mod;
						else
							dp[i][j] = ((2 * dp[i + 1][j - 1]) - dp[n + 1][p - 1]) % mod;
					} else
						dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1]) % mod;
				}
				if (dp[i][j] < 0)
					dp[i][j] += mod;
			}
		}
		return dp[0][dp[0].length - 1] % mod;
	}

}
