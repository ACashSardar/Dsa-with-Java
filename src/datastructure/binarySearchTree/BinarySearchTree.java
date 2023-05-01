package datastructure.binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

class Node {
	Node left;
	Node right;
	int data;

	public Node(int data) {
		this.left = null;
		this.right = null;
		this.data = data;
	}
}

public class BinarySearchTree {

	public static void inOrder(Node root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	public static Node createTree(Node root, int val) {
		if (root == null) {
			return new Node(val);
		} else if (root.data < val) {
			root.right = createTree(root.right, val);
		} else {
			root.left = createTree(root.left, val);
		}
		return root;
	}

	public static Node deleteNode(Node root, int val) {
		if (root == null) {
			System.out.println("Node having the given value was not found");
			return null;
		} else if (root.data == val) {
			if (root.left == null && root.right == null) {
				return null;
			} else if (root.left == null && root.right != null) {
				return root.right;
			} else if (root.left != null && root.right == null) {
				return root.left;
			} else {
				Node inorderPredecessor = getInorderPredecessor(root.left);
				root.data = inorderPredecessor.data;
				System.out.println("Inorder predecessor of " + val + " is " + root.data);
				root.left = deleteNode(root.left, inorderPredecessor.data);
			}
		} else if (root.data < val) {
			root.right = deleteNode(root.right, val);
		} else {
			root.left = deleteNode(root.left, val);
		}
		return root;
	}

	public static Node getInorderPredecessor(Node root) {
		if (root == null)
			return null;
		if (root.right != null) {
			return getInorderPredecessor(root.right);
		}
		// else if (root.right == null)
		return root;
	}

	public static void levelOrder(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int n = q.size();
			for (int i = 0; i < n; i++) {
				Node front = q.poll();
				if (front.left != null)
					q.add(front.left);
				if (front.right != null)
					q.add(front.right);
				System.out.print(front.data + " ");
			}
			System.out.println();
		}
	}

//	TC-O(log(n))
	public static boolean search(Node root, int val) {
		if (root == null)
			return false;
		if (root.data == val)
			return true;
		else if (root.data < val)
			return search(root.right, val);
		else
			return search(root.left, val);
	}

	public static void main(String[] args) {
//		 2
//	    / \
//	   1   3
//	  /     \
//	 0       5
//	        / \
//	       4   6
		Node root = null;
		root = createTree(root, 2);
		root = createTree(root, 1);
		root = createTree(root, 3);
		root = createTree(root, 0);
		root = createTree(root, 5);
		root = createTree(root, 4);
		root = createTree(root, 6);
		System.out.println("IN-ORDER TRAVERSAL");
		inOrder(root);
		System.out.println("\nLEVEL ORDER TRAVERSAL");
		levelOrder(root);
		root = deleteNode(root, 2);
		System.out.println("\nLEVEL ORDER TRAVERSAL");
		levelOrder(root);
		System.out.println("\nIN-ORDER TRAVERSAL");
		inOrder(root);
		System.out.println();
		int key = 5;
		if (search(root, key)) {
			System.out.println(key + " was found");
		} else {
			System.out.println(key + " was not found");
		}
	}

}
