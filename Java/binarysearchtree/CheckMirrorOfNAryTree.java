package binarysearchtree;

import java.util.*;

public class CheckMirrorOfNAryTree {

	static int checkMirrorTree(int n, int e, int[] A, int[] B) {
		List<Stack<Integer>> stack = new ArrayList<>();
		List<Queue<Integer>> queue = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			Stack<Integer> s = new Stack<>();
		//	s.push(-(i + 1));
			stack.add(s);
			Queue<Integer> q = new LinkedList<>();
		//	q.add(-(i + 1));
			queue.add(q);
		}
		//[1, 2, 1, 3]
		//[1, 2, 1, 3]
		for (int i = 0; i < 2 * e; i += 2) {
			stack.get(A[i]).push(A[i + 1]);
			queue.get(B[i]).add(B[i + 1]);
		}

		for (int i = 1; i <= n; i++) {
			while (!stack.get(i).isEmpty() && !queue.get(i).isEmpty()) {
				int a = stack.get(i).pop();
				int b = queue.get(i).remove();
				if (a != b)
					return 0;
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		int n = 3, e = 2;
		int A[] = { 1, 2, 1, 3 };
		int B[] = { 1, 3, 1, 2 };
		System.out.println(checkMirrorTree(n, e, A, B));
	}
}
