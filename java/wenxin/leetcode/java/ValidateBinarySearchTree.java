package wenxin.leetcode.java;

/*
 * problem 98.
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(0);
		ValidateBinarySearchTree instance = new ValidateBinarySearchTree();
		System.out.println(instance.isValidBST(root));
	}

	public boolean isValidBST(TreeNode root) {
		
		double max = Integer.MAX_VALUE;
		max++;
		double min = Integer.MIN_VALUE;
		min--;
		return validate(root, max, min);
	}

	public boolean validate(TreeNode root, double max, double min) {

		if (root == null) {
			return true;
		}

		if (root.val >= max || root.val <= min) {
			return false;
		}

		if (root.left != null && root.right != null) {
			if (root.left.val > root.right.val) {
				return false;
			}
		}

		return validate(root.left, root.val, min) && validate(root.right, max, root.val);
	}

}
