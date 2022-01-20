package binarysearchtree;

import java.util.*;

public class MinwapToMakeBST {

	// Pair class
	static class Pair {
		int val, index;

		Pair(int val, int index) {
			this.val = val;
			this.index = index;
		}

		@Override
		public String toString() {
			return "Pair [val=" + val + ", index=" + index + "]";
		}
		
	}

	static void inorder(int a[], List<Integer> v, int n, int index) {
		if (index >= n)
			return;
		inorder(a, v, n, 2 * index + 1);
		v.add(a[index]);
		inorder(a, v, n, 2 * index + 2);
	}

	public static int minSwaps(List<Integer> arr) {
		int n = arr.size();
		List<Pair> arrPos = new ArrayList<Pair>();
		for (int i = 0; i < n; i++)
			arrPos.add(new Pair(arr.get(i), i));
		arrPos.sort(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.val - o2.val;
			}
		});

		Boolean[] vis = new Boolean[n];
		Arrays.fill(vis, false);

		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (vis[i] || arrPos.get(i).val == i)
				continue;
			int cycle_size = 0;
			int j = i;
			while (!vis[j]) {
				vis[j] = true;
				j = arrPos.get(j).index;
				cycle_size++;
			}
			if (cycle_size > 0) {
				ans += (cycle_size - 1);
			}
		}
		return ans;
	}

	public static void main(String args[]) {
		int a[] = { 5, 6, 7, 8, 9, 10, 11 };
		int n = a.length;
		List<Integer> v = new ArrayList<>();
		inorder(a, v, n, 0);
		System.out.println(minSwaps(v));
	}
}
