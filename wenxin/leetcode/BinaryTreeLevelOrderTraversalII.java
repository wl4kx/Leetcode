/**
 * 
 */
package wenxin.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 107.
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */
public class BinaryTreeLevelOrderTraversalII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
/*
 * similar as Binary Tree Level Order Traversal, just add list to front of the result list instead of the end.
 */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

    	if(root==null)
    		return new ArrayList<List<Integer>>();
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	LinkedList<TreeNode> nodeToTravel = new LinkedList<TreeNode>();
    	LinkedList<Integer> nodeLevel = new LinkedList<Integer>();
    	nodeLevel.add(1);
    	nodeToTravel.addFirst(root);

    	while(!nodeToTravel.isEmpty()){
    		TreeNode next = nodeToTravel.removeLast();
    		int level = nodeLevel.removeLast();

    		List<Integer> list;
    		if(result.size()<level){
        		list = new ArrayList<Integer>();
        		result.add(0, list);
    		}else{
    			list = result.get(0);
    		}
    		list.add(next.val);
    		
    		
    		if(next.left!=null){
    			nodeToTravel.addFirst(next.left);
    			nodeLevel.addFirst(level+1);
    		}
    		if(next.right!=null){
    			nodeToTravel.addFirst(next.right);
    			nodeLevel.addFirst(level+1);
    		}
    		
    	}
    	
    	
        return result;
    
    }
	
}
