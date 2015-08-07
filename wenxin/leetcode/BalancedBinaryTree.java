/**
 * 
 */
package wenxin.leetcode;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 110.
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * my solution travel tree twice, this solution travel only once. http://www.programcreek.com/2013/02/leetcode-balanced-binary-tree-java/
	 */
    public boolean isBalanced(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null)){
        	return true;
        }
        calcDepth(root);
        return isBalancedRecursive(root);
    }
   
    public boolean isBalancedRecursive(TreeNode root){
    	if(root==null || root.left==null && root.right==null){
    		return true;
    	}
    	
    	if(root.left!=null && root.right!=null){
    		return isBalancedRecursive(root.left) && isBalancedRecursive(root.right) && Math.abs(root.left.val-root.right.val)<=1;
    	}
    	
        if(root.left==null){
        	return root.right.val==1;
        }
        if(root.right==null){
        	return root.left.val==1;
        }
        return false;
    	
    }
    
	public int calcDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		root.val = Math.max(calcDepth(root.left)+1, calcDepth(root.right)+1);
		return root.val;
	}

}
