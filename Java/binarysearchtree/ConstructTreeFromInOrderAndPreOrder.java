package binarysearchtree;

public class ConstructTreeFromInOrderAndPreOrder {

	static class Node {
		Node left;
		Node right;
		int val;

		Node(int val) {
			this.val = val;
			left = right = null;
		}
	}

	public static Node buildTree(int inorder[], int preorder[], int n) {
		return buildTree(inorder, 0, n - 1, preorder, 0, n - 1);
	}

	public static Node buildTree(int inorder[], int isi, int iei, int preorder[], int psi, int pei) {
		if (isi > iei)
			return null;
		Node node = new Node(preorder[psi]);
		int idx = isi;
		while (inorder[idx] != preorder[psi]) {
			idx++;
		}
		int tnel = idx - isi;
		node.left = buildTree(inorder, isi, idx - 1, preorder, psi + 1, pei + tnel);
		node.right = buildTree(inorder, idx + 1, iei, preorder, psi + tnel + 1, pei);
		return node;
	}

	public static void main(String[] args) {
		int inorder[] = { 3, 1, 4, 0, 5, 2 };
		int preorder[] = { 0, 1, 3, 4, 2, 5 };
		buildTree(inorder, preorder, inorder.length);
	}
}
