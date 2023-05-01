package datastructure.binarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees_II {
    public static List<TreeNode> func(int i, int j, int [] arr){
        List<TreeNode> ans=new ArrayList<>();
        if(i>j){
            ans.add(null);
            return ans;
        }
        else if(i==j){
            ans.add(new TreeNode(arr[i]));
        }
        else{
            for(int k=i; k<=j; k++){
                List<TreeNode> left=func(i, k-1, arr);
                List<TreeNode> right=func(k+1, j, arr);
                for(TreeNode l: left){
                    for(TreeNode r: right){
                        TreeNode root=new TreeNode(arr[k]);
                        root.left=l;
                        root.right=r;
                        ans.add(root);
                    }
                }
            }
        }
        return ans;
    }
    public static List<TreeNode> generateTrees(int n) {
        int [] arr=new int [n];
        for(int i=0; i<n; i++) arr[i]=i+1;
        return func(0, n-1, arr);
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
		List<TreeNode> allRoots=generateTrees(3);
		for(TreeNode root: allRoots) {
			preOrderTraversal(root);
			System.out.println();
		}
	}

}
