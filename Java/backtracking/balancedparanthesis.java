package backtracking;

public class balancedparanthesis {

	public static void main(String[] args) {
		// balaced parantheses of 2 pair, 3 pair etc
		// 2 pair means ()() / (())
		print_1(2, "", 0, 0);

	}

	public static void print_1(int size, String ans, int openCount, int closeCount) {
		if (openCount > size || closeCount > size || closeCount > openCount) {
			return;
		}
		if (closeCount == openCount && size == openCount) {
			return;
		}
		print_1(size, ans + ")", openCount, closeCount + 1);
		print_1(size, ans + "(", openCount + 1, closeCount);
	}

	public static void print(int size, String ans, int openCount, int closeCount) {
		if (openCount > size || closeCount > size || closeCount > openCount) {
			return;
		}
		if (openCount == closeCount && size == openCount) {
			System.out.println(ans);
			return;
		}
		print(size, ans + ')', openCount, closeCount + 1);
		print(size, ans + '(', openCount + 1, closeCount);
	}

}
