package binnarytree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

import binnarytree.DiagonalOrder.Node;

public class MaxWidthBinaryTree {

	static Node root;

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
			return "" + data + "";
		}
	}

	static class Pair<K, V> {
		int index;
		Node node;

		Pair(Node node, int index) {
			this.index = index;
			this.node = node;
		}

		public int getValue() {
			return this.index;
		}

		public Node getKey() {
			return this.node;
		}
	}

	/*
	 * static class Pair { int index; Node node;
	 * 
	 * Pair(Node node, int index) { this.index = index; this.node = node; } }
	 */

	public static int widthOfBinaryTree(Node root) {
		if (root == null)
			return 0;
		Queue<Pair<Node, Integer>> queue = new LinkedList<>();
		queue.offer(new Pair<>(root, 0));
		int result = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			int left = queue.peek().getValue(), right = left;
			for (int i = 0; i < size; i++) {
				Pair<Node, Integer> p = queue.poll();
				Node node = p.getKey();
				right = p.getValue();
				if (node.left != null) {
					queue.offer(new Pair<>(node.left, right * 2));
				}
				if (node.right != null) {
					queue.offer(new Pair<>(node.right, right * 2 + 1));
				}
			}
			result = Math.max(right - left + 1, result);
		}
		return result;
	}

	public static int width(Node root) {
		Queue<Pair<Node, Integer>> queue = new ArrayDeque<>();
		queue.add(new Pair<>(root, 0));
		int max = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			int lm = queue.peek().index;
			int rm = queue.peek().index;
			while (size-- > 0) {
				Pair<Node, Integer> temp = queue.remove();
				rm = temp.index;
				if (temp.node.left != null) {
					queue.add(new Pair<>(temp.node.left, 2 * lm + 1));
				}
				if (temp.node.right != null) {
					queue.add(new Pair<>(temp.node.right, 2 * rm + 2));
				}
			}
			max = Math.max(max, rm - lm + 1);
		}
		return max;
	}

	public static void main(String[] args) {
		root = new Node(10);
		root.left = new Node(30);
		root.right = new Node(20);
		root.left.left = new Node(60);
		root.left.right = new Node(50);
		root.left.left.right = new Node(9);
		root.right.right = new Node(90);
		root.right.left = new Node(70);
		root.right.right.right = new Node(100);
		root.right.right.left = new Node(6);
		System.out.println(widthOfBinaryTree(root));
	}
}
