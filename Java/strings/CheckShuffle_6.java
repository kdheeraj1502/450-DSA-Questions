package strings;

public class CheckShuffle_6 {

	public static void main(String[] args) {
		System.out.println(checkshuffle_self("xy", "12", "2xy1"));

	}

	public static boolean checkshuffle(String s1, String s2, String res) {
		int i = 0, j = 0, k = 0;
		while (k < res.length()) {
			if (i < s1.length() && s1.charAt(i) == res.charAt(k)) {
				k++;
				i++;
			} else if (j < s2.length() && s2.charAt(j) == res.charAt(k)) {
				j++;
				k++;
			} else {
				return false;
			}
		}

		return true;
	}

	public static boolean checkshuffle_self(String s1, String s2, String res) {
		int i = 0, j = 0, k = 0;
		while(k < res.length()){
			if(i < s1.length() && s1.charAt(i) == res.charAt(k)){
				i++;
				k++;
			} else if(j < s2.length() && s2.charAt(j) == res.charAt(k)){
				j++;
				k++;
			} else{
				return false;
			}
		}
		return true;
	}

}
