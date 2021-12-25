package binnarytree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class levelorder {

	////      10
//	      20      30
//	  40     60      50
	
	public static void levelorder(Node parent) {
		Queue<Node> queue = new ArrayDeque<>();
		
		queue.add(parent);  // 10 , 20, 30 40, 60, 50
		
		
		while (!queue.isEmpty()) {
			
			Node temp = queue.remove();
			
			System.out.print(temp.data + " ");
			
			if (temp.left != null) {
				queue.add(temp.left);
			}
			
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
	}
	
	public static void reverseLevelorder(Node parent) {
		Queue<Node> queue = new ArrayDeque<>();
		Stack<Node> stack = new Stack<>();
		
		queue.add(parent); 
		
		while (!queue.isEmpty()) {
			
			Node temp = queue.remove();
			stack.push(temp);
			if (temp.right != null) {
				queue.add(temp.right);
			}

			if (temp.left != null) {
				queue.add(temp.left);
			}
			
		}
		
		
		while(!stack.isEmpty()) {
			Node temp = stack.pop();
			System.out.print(temp.data + " ,");
		}
		
		
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.right.right = new Node(70);
		root.left.left = new Node(40);
		root.left.right = new Node(60);
		
		levelorder(root);
		System.out.println();
		reverseLevelorder(root);
	}
}

