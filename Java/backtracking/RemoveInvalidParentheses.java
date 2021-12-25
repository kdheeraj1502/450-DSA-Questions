package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class RemoveInvalidParentheses {
	HashSet<String> map = new HashSet<>();
	HashSet<String> ans = new HashSet<>();

	public int getmin(String s) {
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (!st.isEmpty() && s.charAt(i) == ')' && st.peek() == '(') {
				st.pop();
			} else if (s.charAt(i) == '(' || s.charAt(i) == ')')
				st.push(s.charAt(i));
		}
		return st.size();
	}

	public static void main(String[] args) {
		RemoveInvalidParentheses_1 rp = new RemoveInvalidParentheses_1();
// 		String s = "())))()v(k";
//		String s = "(a)())()";
		String s = "()())()";
	//	int min = rp.getmin(s);
//		rp.print(s, min);
//		rp.showResult();
	}

	public void showResult() {
		List<String> fans = new ArrayList<>();
		for (String val : ans) {
			fans.add(val);
		}
		System.out.println(fans);
	}

	public void print(String s, int minnoofremoval) {
		if (minnoofremoval == 0) {
			// check if valid or not
			if (getmin(s) == 0) {
				if (!ans.contains(s)) {
					ans.add(s);
				}
			}
		}

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ')' && s.charAt(i) != '(') {
				continue;
			}
			String res = s.substring(0, i) + s.substring(i + 1);
			if (!map.contains(res)) {
				map.add(res);
				print(res, minnoofremoval - 1);
			}
		}
	}

}
