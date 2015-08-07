/**
 * 
 */
package wenxin.leetcode;


/**
 * @author liao.wenxin
 *
 */
/*
 * problem 101.
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {

	/**
	 * @param args
	 */
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return recursiveCheck(root.left, root.right);
	}
    
	public boolean recursiveCheck(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		} else if (left != null && right != null) {
			if(left.val!=right.val){
				return false;
			}
			return recursiveCheck(left.left, right.right) && recursiveCheck(left.right, right.left);
		} else {
			return false;
		}
	}
    
}
