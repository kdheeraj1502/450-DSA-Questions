package binnarytree;

import java.util.*;

public class RightView {
	static class Node {
		public int data;
		public Node left;
		public Node right;

		Node(int data) {
			this.data = data;
		}

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
		
	}

	static ArrayList<Integer> rightView(Node node) {
		ArrayList<Integer> result = new ArrayList<>();
		if (node == null)
			return result;
		if (node.left == null && node.right == null) {
			result.add(node.data);
			return result;
		}
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 1; i <= size; i++) {
				Node temp = queue.remove();
				if (i == 1) {
					result.add(temp.data);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}
				if (temp.left != null) {
					queue.add(temp.left);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Node node = new Node(10);
		node.left = new Node(20);
		node.right = new Node(30);
		node.left.left = new Node(40);
		node.left.right = new Node(60);
		
		System.out.println(rightView(node));
	}
}
