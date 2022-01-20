package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class CountOfNumberOfStringInArray_23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] arr = { 
				{ 'B', 'B', 'M', 'B', 'B', 'B' }, 
				{ 'C', 'B', 'A', 'B', 'B', 'B' },
				{ 'I', 'B', 'G', 'B', 'B', 'B' }, 
				{ 'G', 'B', 'I', 'B', 'B', 'B' }, 
				{ 'A', 'B', 'C', 'B', 'B', 'B' },
				{ 'M', 'C', 'I', 'G', 'A', 'M' } };

		char[][] grid = { { 'D', 'D', 'D', 'G', 'D', 'D' }, { 'B', 'B', 'D', 'E', 'B', 'S' },
				{ 'B', 'S', 'K', 'E', 'B', 'K' }, { 'D', 'D', 'D', 'D', 'D', 'E' }, { 'D', 'D', 'D', 'D', 'D', 'E' },
				{ 'D', 'D', 'D', 'D', 'D', 'G' } };
		System.out.println(move(arr, "MAGIC"));

		String needle = "MAGIC";
		String input[] = { "BBABBM", "CBMBBA", "IBABBG", "GOZBBI", "ABCBBC", "MCIGAM" };
		System.out.println("--------------------------------------");
		int nums[] = { 5, 6, 7, 1, 2, 3 };
	//	IntStream.of(nums).filter(x -> x % 2 == 0).forEach(System.out::println);
		
		DoubleStream.of(0);
		String str[] = new String[input.length];
		int i;
		for (i = 0; i < input.length; ++i) {
			str[i] = input[i];
		}

		System.out.println("count: " + searchString(needle, 0, 0, str, str.length, str[0].length()));

	}

	public static int solve(int i, int j, String s, int ind, char[][] arr) {
		if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length) {
			return 0;
		}
		int count = 0;
		if (arr[i][j] == s.charAt(ind)) {
			char temp = s.charAt(ind);
			arr[i][j] = '0';
			ind++;
			if (ind == s.length()) {
				count = 1;
			} else {
				if(i == 5 && j == 2) {
					System.out.println("");
				}
				count += solve(i, j + 1, s, ind, arr);
				count += solve(i, j - 1, s, ind, arr);
				count += solve(i + 1, j, s, ind, arr);
				count += solve(i - 1, j, s, ind, arr);
			}
			arr[i][j] = temp;
		}
		return count;

	}

	public static int move(char[][] arr, String s) {
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				total += solve(i, j, s, 0, arr);
			}
		}
		return total;
	}

	static int internalSearch(String needle, int row, int col, String hay[], int row_max, int col_max, int index) {
		int found = 0;
		//"BBABBM", "CBMBBA", "IBABBG", "GOZBBI", "ABBBBC", "MCIGAM"
		if (row >= 0 && row <= row_max && col >= 0 && col <= col_max && index < needle.length()
				&& needle.charAt(index) == hay[row].charAt(col)) {
			char match = needle.charAt(index);
			index += 1;
			hay[row] = hay[row].substring(0, col) + "0" + hay[row].substring(col + 1);
			if (index == needle.length()) {
				found = 1;
			} else {
				// Through Backtrack searching
				// in every directions
				found += internalSearch(needle, row, col + 1, hay, row_max, col_max, index);
				found += internalSearch(needle, row, col - 1, hay, row_max, col_max, index);
				found += internalSearch(needle, row + 1, col, hay, row_max, col_max, index);
				found += internalSearch(needle, row - 1, col, hay, row_max, col_max, index);
			}

			hay[row] = hay[row].substring(0, col) + match + hay[row].substring(col + 1);
		}
		return found;
	}

	static int searchString(String needle, int row, int col, String str[], int row_count, int col_count) {
		int found = 0;
		int r, c;
		for (r = 0; r < row_count; ++r) {
			for (c = 0; c < col_count; ++c) {
				found += internalSearch(needle, r, c, str, row_count - 1, col_count - 1, 0);
			}
		}
		return found;
	}
}
