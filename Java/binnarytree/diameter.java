package binnarytree;

import java.util.Scanner;

public class diameter {

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

	public int height(Node root) {
		return root != null ? Math.max(height(root.left), height(root.right)) + 1 : 0;

	}

	public int diameter1() {
		return diameter1(this.root);
	}

	// but this is inefficient
	private int diameter1(Node parent) {
		if (parent == null) {
			return 0;
		}

		int left = diameter1(parent.left);
		int right = diameter1(parent.right);
		int leftHeight = height(parent.left);
		int rightHeight = height(parent.right);
		System.out.println("Node is " + parent.data + " left Height " + leftHeight + " right height " + rightHeight);
		int height = height(parent.left) + height(parent.right) + 1;

		return Math.max(height, Math.max(left, right));

	}

	public class diapair {
		int height;
		int dia;
	}

	public int diameter2() {
		return diameter2(this.root).dia;
	}

	// but this is efficient
	private diapair diameter2(Node parent) {
		if (parent == null) {
			diapair d = new diapair();
			d.height = -1;
			d.dia = 0;
			return d;
		}

		diapair ld = diameter2(parent.left);
		diapair rd = diameter2(parent.right);

		diapair mp = new diapair();
		int f = ld.height + rd.height + 2;
		mp.dia = Math.max(f, Math.max(ld.dia, rd.dia));
		mp.height = Math.max(ld.height, rd.height) + 1;

		return mp;

	}

	public static void main(String[] args) {
		diameter m = new diameter();
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.right.right = new Node(50);
		root.left.left = new Node(40);
		root.left.right = new Node(60);
		m.root = root;
		// m.display();
		System.out.println(m.diameter1());
	}

}

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
	}

	Node(int data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
