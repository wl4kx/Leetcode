/**
 * 
 */
package wenxin.leetcode;

import java.util.LinkedList;

/**
 * @author liao.wenxin
 *
 */
public class PathSum {

	/**
	 * @param args
	 */
	/*
	 * problem 112.
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
	 */
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		n1.left = n2;
		
		System.out.println(hasPathSum(n1, 1));

	}

    public static boolean hasPathSum(TreeNode root, int sum) {
    	if(root==null){
    		return false;
    	}
    	LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
    	LinkedList<Integer> sumList = new LinkedList<Integer>();
    	nodeList.add(root);
    	sumList.add(root.val);
    	
    	while(nodeList.size()>0){
    		TreeNode aNode = nodeList.removeLast();
    		Integer aSum = sumList.removeLast();
    		if(aNode.left==null && aNode.right==null){
    			if(aSum==sum){
    				return true;
    			}
    		}
    		if(aNode.left!=null){
    			nodeList.add(aNode.left);
    			sumList.add(aSum+aNode.left.val);
    		}
    		if(aNode.right!=null){
    			nodeList.add(aNode.right);
    			sumList.add(aSum+aNode.right.val);
    		}
    	}
    	return false;
    }
}
