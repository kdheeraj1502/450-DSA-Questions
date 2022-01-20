package strings;

public class LongestRepeatingSubsequence_9 {

	public static void main(String[] args) {
		//LRS("abacbc");
		LRS("axxxy");;

	}

	public static void LRS(String s) {

		int[][] dp = new int[s.length() + 1][s.length() + 1];
		
		for (int i = s.length() - 1; i >= 0; i--) {
			
			for (int j = s.length() - 1; j >= 0; j--) {

				if (s.charAt(i) == s.charAt(j) && i != j) {
					dp[i][j] = dp[i + 1][j + 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
				}
			}
		}
		System.out.println(dp[0][0]);
	}
}
