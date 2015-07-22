package wenxin.leetcode;

/*
 * problem 98.
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public class Solution {
	    public boolean isValidBST(TreeNode root) {
	    	
	    	if(root==null){
	    		return true;
	    	}
	    	
	    	if(root.left!=null && root.right!=null){
	    		if(root.left.val>root.right.val){
	    			return false;
	    		}
	    	}
	    	
	    	if(root.left!=null && root.left.val>=root.val){
	    		return false;
	    	}
	    	
	    	if(root.right!=null && root.right.val<=root.val){
	    		return false;
	    	}
	    	
	    	
	    	
			return isValidBST(root.left) && isValidBST(root.right);
	        
	    }
	}
}
