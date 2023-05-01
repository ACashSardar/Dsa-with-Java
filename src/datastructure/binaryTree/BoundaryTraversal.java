package datastructure.binaryTree;

import java.util.ArrayList;
import java.util.Collections;

public class BoundaryTraversal {

	public static boolean isLeaf(TreeNode root){
        return root.left==null && root.right==null;
    }
    
    public static void addLeafNodes(TreeNode root, ArrayList <Integer> ds){
        if(root==null) return;
        if(isLeaf(root)) ds.add(root.val);
        addLeafNodes(root.left, ds);
        addLeafNodes(root.right, ds);
    }
    
    public static void addLeftNodes(TreeNode root, ArrayList <Integer> ds){
        if(root==null || isLeaf(root)){
           return; 
        } 
        ds.add(root.val);
        
        if(root.left!=null){
            addLeftNodes(root.left, ds);
        }
        else if(root.right!=null){
            addLeftNodes(root.right, ds);
        }
    }
    
    public static void addRightNodes(TreeNode root, ArrayList <Integer> ds){
        if(root==null || isLeaf(root)){
           return; 
        } 
        ds.add(root.val);
        
        if(root.right!=null){
            addRightNodes(root.right, ds);
        }
        else if(root.left!=null){
            addRightNodes(root.left, ds);
        }
    }

	public static ArrayList<Integer> traverseBoundary(TreeNode root){

		ArrayList <Integer> boundary=new ArrayList<>();
	    
	    boundary.add(root.val);
	    
	    if(isLeaf(root)) return boundary;
	    
	    // adding left boundary
	    addLeftNodes(root.left, boundary);
	    // adding leaf nodes
	    addLeafNodes(root, boundary);
	    
	    ArrayList <Integer> temp=new ArrayList<>();
	    // adding right boundary in reverse order
	    addRightNodes(root.right, temp);
	    Collections.reverse(temp);
	    
	    for(int elem: temp) boundary.add(elem);
	    
	    return boundary;
	}
	
	public static void main(String[] args) {
		

	}

}
