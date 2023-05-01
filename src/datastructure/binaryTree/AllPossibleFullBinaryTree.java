package datastructure.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTree {
	public static List<TreeNode> allPossibleFBT(int n) {
		if (n == 1) {
			List<TreeNode> base = new ArrayList<>();
			base.add(new TreeNode(0));
			return base;
		}

		List<TreeNode> ans = new ArrayList<>();
		for (int i = 1; i < n; i += 2) {
			List<TreeNode> left = allPossibleFBT(i);
			List<TreeNode> right = allPossibleFBT(n - 1 - i);
			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode root = new TreeNode(0);
					root.left = l;
					root.right = r;
					ans.add(root);
				}
			}
		}
		return ans;
	}
	
    public static void preOrderTraversal(TreeNode root) {
    	if(root==null) {
    		System.out.print("null ");
    		return;
    	}
    	System.out.print(root.val+" ");
    	preOrderTraversal(root.left);
    	preOrderTraversal(root.right);
    }

	public static void main(String[] args) {
		List<TreeNode> allRoots=allPossibleFBT(9);
		for(TreeNode root: allRoots) {
			preOrderTraversal(root);
			System.out.println();
		}
	}

}
