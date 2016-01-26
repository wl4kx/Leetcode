/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 104.
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int maxDepth(TreeNode root) {
    	
    	if(root==null){
    		return 0;
    	}
    	
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        traverse(root, 1, max);
        return max[0];
    }
    
    public void traverse(TreeNode root, int depth, int[] max){
    	if(root.left==null & root.right==null){
    		max[0] = Math.max(depth, max[0]);
    	}else{ 
    		if(root.left !=null){
        		traverse(root.left, depth+1, max);
        	}

    		if(root.right!=null){
        		traverse(root.right, depth+1, max);
        	}
    	}
    }
	
}
