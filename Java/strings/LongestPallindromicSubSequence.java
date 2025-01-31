package strings;

public class LongestPallindromicSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subsequenceoptimised("acdbba");
	}

	public static void subsequenceoptimised(String str) {

		int[][] dp = new int[str.length()][str.length()];
		// gap
		for (int g = 0; g < dp.length; g++) {
			for (int i = 0, j = g; i < dp.length && j < dp.length; i++, j++) {
				// if gap ==0
				if (g == 0) {
					dp[i][j] = 1;
				} else if (g == 1) {
					if (str.charAt(i) == str.charAt(j)) {
						dp[i][j] = 2;
					} else {
						dp[i][j] = 1;
					}
				} else {
					if (str.charAt(i) == str.charAt(j)) {
						dp[i][j] = 2 + dp[i + 1][j - 1];
					} else {
						dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
					}

				}
			}
		}

		System.out.println(dp[0][str.length() - 1]);

	}

}
