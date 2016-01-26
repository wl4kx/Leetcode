/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 99. Solution from http://rleetcode.blogspot.com/2013/09/recover-binary-search-tree.html
 * 			For O(1) space solution, use Morris Traversal to traver tree in order.
 * Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
 */
public class RecoverBinarySearchTree {
	TreeNode pre;
	TreeNode first;
	TreeNode second;

	public void inorder(TreeNode root) {
		if (root == null)
			return;

		inorder(root.left);
		if (pre == null) {
			pre = root; // pre指针初始
		} else {
			if (pre.val > root.val) {
				if (first == null) {
					first = pre;// 第一个�?�序�?
				}
				second = root; // 不断寻找�?后一个�?�序�?
			}
			pre = root; // pre指针每次后移�?�?
		}
		inorder(root.right);
	}

	public void recoverTree(TreeNode root) {
		pre = null;
		first = null;
		second = null;
		inorder(root);
		if (first != null && second != null) {
			int tmp = first.val;
			first.val = second.val;
			second.val = tmp;
		}
	}
}
