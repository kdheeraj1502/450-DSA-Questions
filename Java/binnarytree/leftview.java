package binnarytree;

import java.util.*;

public class leftview {

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
	}

	private Node root = null;
	private int size = 0;

	private Node input(Scanner scn, Node parent, Boolean isleftorright) {
		if (parent == null) {
			System.out.println("Enter data for the parent node");
		} else {

			if (isleftorright) {
				System.out.println("Enter data for the left child of " + parent.data);
			} else {
				System.out.println("Enter data for the right child of " + parent.data);
			}
		}

		int data = scn.nextInt();
		Node node = new Node(data, null, null);
		this.size++;
		System.out.println("does " + node.data + " has left child");
		Boolean choice = false;
		choice = scn.nextBoolean();
		if (choice) {
			node.left = input(scn, node, true);
		}

		choice = false;
		System.out.println("does " + node.data + " has right child");
		choice = scn.nextBoolean();
		if (choice) {
			node.right = input(scn, node, false);
		}

		return node;

	}

	public void display() {
		display(this.root);
	}

	private void display(Node parent) {

		String str = "";
		if (parent.left != null) {
			str += parent.left.data + " => ";
		} else {
			str += "End => ";
		}
		str += parent.data;
		if (parent.right != null) {
			str += " <= " + parent.right.data;
		} else {
			str += " <= End";
		}
		System.out.println(str);
		if (parent.left != null) {
			display(parent.left);
		}
		if (parent.right != null) {
			display(parent.right);
		}

	}

	public ArrayList<Integer> leftview() {
		return leftview(this.root);
	}

	private ArrayList<Integer> leftview(Node parent) {
		Queue<Node> queue = new ArrayDeque<>();
		ArrayList<Integer> result = new ArrayList<>();
		queue.add(parent);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 1; i <= size; i++) {
				Node temp = queue.remove();
				if (i == 1) {
					result.add(temp.data);
				}
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10 true 20 true 40 false false true 50 false false true 30 true 60 false
		// false true 73 false false

		Node root = new Node(10);
		root.right = new Node(30);
		root.left = new Node(20);
		root.left.left = new Node(40);
		root.left.right = new Node(60);

		leftview m = new leftview();
		m.root = root;
		// m.display();
		System.out.println();
		System.out.println(m.leftview());

	}

}
