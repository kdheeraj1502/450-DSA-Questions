package binnarytree;

import java.util.*;

public class ValidTreeOrNot {

	public boolean validTree(int n, int[][] edges) {
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			list.get(edge[0]).add(edge[1]);
			list.get(edge[1]).add(edge[0]);
		}
		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		while (!queue.isEmpty()) {
			int id = queue.poll();
			if (visited[id]) {
				return false;
			}
			visited[id] = true;
			for (int neighbor : list.get(id)) {
				if (!visited[neighbor]) {
					queue.offer(neighbor);
				}
			}
		}

		for (boolean b : visited) {
			if (!b)
				return false;
		}
		return true;
	}
}
