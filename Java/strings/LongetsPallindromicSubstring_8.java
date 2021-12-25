package strings;

public class LongetsPallindromicSubstring_8 {

	public static void main(String[] args) {
//		substring("naman");
//		System.out.println(pallindrome("naman"));
		substringoptimised("aaaabbaa");
		String str = "rfkqyuqfjkxy";
		System.out.println(longestPalin(str));
	}

	// brute force O(n3)
	public static void substring(String str) {
		int maxlength = 0;
		String finalans = "";
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				String s = str.substring(i, j);
				System.out.println(s);
				if (pallindrome(s)) {
					if (maxlength < s.length()) {
						maxlength = s.length();
						finalans = s;
					}
				}
			}
		}
		System.out.println(maxlength);
		System.out.println(finalans);
	}

	// O(n2)
	public static void substringoptimised(String str) {

		int[][] dp = new int[str.length()][str.length()];
		int finali = 0, finalj = 0;
		// gap
		for (int g = 0; g < dp.length; g++) {
			for (int i = 0, j = g; i < dp.length && j < dp.length; i++, j++) {
				// if gap ==0
				if (g == 0) {
					dp[i][j] = 1;
				} else if (g == 1) {
					if (str.charAt(i) == str.charAt(j)) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = 0;
					}
				} else {

					if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == 1) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = 0;
					}

				}

				if (dp[i][j] == 1) {
					finali = i;
					finalj = j;
				}
			}
		}

		System.out.println(str.substring(finali, finalj + 1));

	}

	public static boolean pallindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i <= j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			} else {
				i++;
				j--;
			}
		}
		return true;
	}



	static int resultLength;
	static int resultStart;

	static String longestPalin(String s){
		if(s.length() < 2){
			return s;
		}
		for(int start = 0; start < s.length() - 1; start++){
			expandRange(s, start, start);
			expandRange(s, start, start + 1);
		}
		return s.substring(resultStart, resultLength + resultStart);
	}

	static void expandRange(String s, int start, int end){
		while(start >= 0 && end < s.length() &&
				s.charAt(start) == s.charAt(end)){
			start--;
			end++;
		}
		if(resultLength < (end - start - 1)){
			resultStart = start + 1;
			resultLength = end - start - 1;
		}
	}

}
