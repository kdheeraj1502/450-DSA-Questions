package binnarytree;

import java.util.*;
public class mirror {
	public class BinaryTree {

		private class Node {
			int data;
			Node left;
			Node right;

			Node(int data, Node left, Node right) {
				this.data = data;
				this.left = left;
				this.right = right;

			}

		}

		private Node root = null;
		private int size = 0;

		BinaryTree() {
			Scanner scn = new Scanner(System.in);
			this.root = input(scn, null, false);

		}

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

		public void mirror(BinaryTree tree) {
			this.root = mirror(tree.root);
		}

		private Node mirror(Node parent) {
			if (parent == null) {
				return null;
			}
			Node node = new Node(0, null, null);
			node.data = parent.data;
			node.left = mirror(parent.right);
			node.right = mirror(parent.left);

			return node;
		}
		
		private Node mirror_self(Node parent) {
			Queue<Node> queue = new LinkedList<>();
			queue.add(parent);
			while(!queue.isEmpty()) {
				Node temp = queue.remove();
				if(temp != null) {
					Node temp1 = temp.left;
					temp.left = temp.right;
					temp.right = temp1;
					queue.add(temp.left);
					queue.add(temp.right);
				}
			}
			return parent;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10 true 20 true 40 false false true 50 false false true 30 true 60 false
		// false true 73 false false
		mirror m = new mirror();
		BinaryTree tree = m.new BinaryTree();
		tree.display();
		BinaryTree tree2 = tree;
		tree2.mirror(tree);
		System.out.println();
		System.out.println();
		tree2.display();

	}

}
