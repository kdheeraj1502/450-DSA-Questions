package backtracking;

import java.util.*;

public class wordbreak2 {

	static List<String> wordBreak(int n, List<String> dict, String s) {
		List<String> result = new ArrayList<>();
		print(dict, s, "", result);
		return result;
	}

	static void print(List<String> dict, String s, String ans, List<String> fans) {
		if (s.length() == 0) {
			fans.add(ans);
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			String prefix = s.substring(0, i + 1);
			if (dict.contains(prefix)) {
				String res = s.substring(i + 1);
				if (res.length() == 0) {
					print(dict, res, ans + prefix, fans);
				} else {
					print(dict, res, ans + prefix + " ", fans);
				}
			}
		}
	}

	static boolean[] marked;

	public static boolean wordBreak(String s, List<String> wordDict) {
		marked = new boolean[s.length()];
		return wordBreak(s, wordDict, 0);
	}

	public static boolean wordBreak(String s, List<String> wordDict, int start) {
		if (start >= s.length()) {
			return true;
		}
		if (marked[start]) {
			return false;
		}
		for (String word : wordDict) {
			if (s.startsWith(word, start)) {
				if (wordBreak(s, wordDict, start + word.length()))
					return true;
				marked[start] = true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> dict = Arrays.asList("cats", "cat", "and", "sand", "dog");
		String s = "catsanddog";
	//	System.out.println(wordBreak(dict.size(), dict, s));

		String s1 = "bb";
		// List<String> words = Arrays.asList("a","b","bbb","bbbb");
		// System.out.println(wordBreak(s1, words));
		String s2 = "catsandog";
		List<String> words1 = Arrays.asList("cats", "dog", "sand", "and", "cat");
		//System.out.println(wordBreak(s2, words1));

		String s3 = "aaab";
		List<String> words2 = Arrays.asList("a", "aa", "aaa");
		System.out.println(wordBreak(s3, words2));
	}

}
