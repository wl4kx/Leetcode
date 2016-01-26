/**
 * 
 */
package wenxin.leetcode.java;

import java.util.Stack;

/**
 * @author liao.wenxin
 *
 */
/*
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 â‰? k â‰? BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Hint:

Try to utilize the property of a BST.
What if you could modify the BST node's structure?
The optimal runtime complexity is O(height of BST).
 */
public class KthSmallestElementInABST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<TreeNode>();

		TreeNode p = root;
		int result = 0;

		while (!stack.isEmpty() || p != null) {
			if(p!=null){
				stack.push(p);
				p = p.left;
			}else{
				TreeNode t = stack.pop();
				int val = t.val;
				k--;
				if(k==0){
					return val;
				}
				p = t.right;
			}
		}

		return result;
	}
    
}
