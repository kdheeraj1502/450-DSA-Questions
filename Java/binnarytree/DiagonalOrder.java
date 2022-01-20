package binnarytree;

import java.util.*;

public class DiagonalOrder {
	
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
	}
	
	public static List<List<Integer>> diagonalView(Node root){
		List<List<Integer>> result = new ArrayList<>();
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<>();
			while(size-- > 0) {
				Node temp = queue.remove();
				while(temp != null) {
					list.add(temp.data);
					if(temp.left != null) {
						queue.add(temp.left);
					} 
					temp = temp.right;
				}
			}
			result.add(list);
		}
		return result;
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
		System.out.println(diagonalView(root));
	}
}
