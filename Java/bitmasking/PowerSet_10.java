package bitmasking;

import java.util.*;

public class PowerSet_10 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		subset("abc", "", list);
		System.out.println(list);
		System.out.println(AllPossibleStrings("abc"));
	}

	public static void subset(String s, String ans, List<String> list) {
		if (s.length() == 0) {
		//	System.out.println(ans);
			list.add(ans);
			return;
		}
		char ch = s.charAt(0);
		String ros = s.substring(1);
		subset(ros, ans, list);
		subset(ros, ans + ch, list);
	}

	static public List<String> AllPossibleStrings(String s)
	{
		List<String> list = new LinkedList<>();
		help(s , "" , list);
		Collections.sort(list);
		list.remove(0);
		return list;

	}
	static void help(String s , String ans , List<String> list){
		if(s.length() == 0){
			list.add(ans);
			return;
		}
		char ch = s.charAt(0);
		String rest = s.substring(1);
		help(rest , ans , list);
		help(rest , ans + ch , list);
	}
}
