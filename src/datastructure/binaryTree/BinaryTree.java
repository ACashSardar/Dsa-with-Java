package datastructure.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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

public class BinaryTree {

	static Scanner sc = null;
	static Node prev = null;
	static int maxDiameter = 0;

	public static Node createTree() {
		Node root = null;
		System.out.print("Enter data: ");
		int data = sc.nextInt();
		if (data == -1)
			return null;
		root = new Node(data);
		System.out.println("Enter left for " + data);
		root.left = createTree();
		System.out.println("Enter right for " + data);
		root.right = createTree();
		return root;
	}

	public static Node createTreeHardCode() {

//		 1
//	    / \
//	   2   3
//	  / \   \
//	 4   5   7
//	    /
//	   6

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.right = new Node(7);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(6);

		return root;
	}

	public static void inOrder(Node root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	public static void preOrder(Node root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void postOrder(Node root) {
		if (root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
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

	public static void leftView(Node root) {
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
				if (i == 0)
					System.out.print(front.data + " ");
			}
			System.out.println();
		}
	}

	public static void rightView(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int n = q.size();
			for (int i = 0; i < n; i++) {
				Node front = q.poll();
				if (front != null && front.left != null)
					q.add(front.left);
				if (front != null && front.right != null)
					q.add(front.right);
				if (front != null && i == n - 1)
					System.out.print(front.data + " ");
			}
			System.out.println();
		}
	}

	public static int height(Node root) {
		if (root == null)
			return 0;
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

		return Math.max(leftHeight, rightHeight) + 1;
	}

	public static int size(Node root) {
		if (root == null)
			return 0;
		int leftCount = size(root.left);
		int rightCount = size(root.right);

		return leftCount + rightCount + 1;
	}

	public static int diameter(Node root) {
		height(root);
		return maxDiameter;
	}

	public static void flattenTree(Node root) {

		if (root == null || (root.left == null && root.right == null)) {
			prev = root;
			return;
		}
		if (root.left != null) {
			flattenTree(root.left);
			Node temp = root.right;
			root.right = root.left;
			root.left = null;
			prev.right = temp;
		}
		flattenTree(root.right);
	}

	public static void main(String[] args) {
		System.out.println("------------ Binary Tree Demo ----------");
		sc = new Scanner(System.in);
		Node root = createTreeHardCode();
		System.out.println("In Order");
		inOrder(root);
		System.out.println();
		System.out.println("Height of the tree=" + height(root));
		System.out.println("Node count of the tree=" + size(root));
		System.out.println("Level Order");
		levelOrder(root);
		System.out.println("Left View");
		leftView(root);
		System.out.println("Right view");
		rightView(root);
		System.out.println("Diameter="+diameter(root));
		System.out.println("Flatten view");
		flattenTree(root);
		levelOrder(root);
		
	}
}
