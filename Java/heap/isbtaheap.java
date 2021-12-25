package heap;

public class isbtaheap {
	
	private Node root = null;
	
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	treefromstring m = new treefromstring();
	//	BinaryTree tree = m.new BinaryTree("5(2)(3)");
	//	tree.display();
		isbtaheap i = new isbtaheap();
		System.out.println();

		System.out.println(isHeap(i.root));
	}

	public static boolean isHeap(Node root) {

		return (isHeapmax(root) && iscomplete(root, noofnodes(root), 0));

	}

	public static boolean isHeapmax(Node root) {
		if (root == null) {
			return true;
		}
		if (root.left != null && root.data < root.left.data || root.right != null && root.data < root.right.data) {
			return false;
		}
		boolean left = isHeapmax(root.left);
		boolean right = isHeapmax(root.right);

		if (left && right) {
			return true;
		}
		return false;

	}

	public static int noofnodes(Node root) {
		if (root == null) {
			return 0;
		}

		return (1 + noofnodes(root.left) + noofnodes(root.right));
	}

	public static boolean iscomplete(Node root, int totalnodes, int index) {
		if (root == null) {
			return true;
		}

		if (index > totalnodes) {
			return false;
		}

		return (iscomplete(root.left, totalnodes, 2 * index + 1) && iscomplete(root.right, totalnodes, 2 * index + 2));

	}

}
