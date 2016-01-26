/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 111.
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MinimumDepthOfBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinimumDepthOfBinaryTree instance = new MinimumDepthOfBinaryTree();
		TreeNode root = new TreeNode(1);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(1);
		TreeNode n4  = new TreeNode(1);
		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n1.right = n4;
		
		System.out.println(instance.minDepth(root));

	}
	
    public int minDepth(TreeNode root) {
    	
    	if(root==null){
    		return 0;
    	}
    	
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        traverse(root, 1, min);
        return min[0];
    }
    
    public void traverse(TreeNode root, int depth, int[] min){
    	if(root.left==null & root.right==null){
    		min[0] = Math.min(depth, min[0]);
    	}else{ 
    		if(root.left !=null){
        		traverse(root.left, depth+1, min);
        	}

    		if(root.right!=null){
        		traverse(root.right, depth+1, min);
        	}
    	}
    }

}
