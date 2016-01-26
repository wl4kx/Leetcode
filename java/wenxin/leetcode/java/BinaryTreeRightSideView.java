/**
 * 
 */
package wenxin.leetcode.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liao.wenxin
 *
 */
/*
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 */
public class BinaryTreeRightSideView {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeRightSideView instance = new BinaryTreeRightSideView();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.left = n2;
		n1.right = n3;
		n2.right = n5;
		n3.right = n4;
		List<Integer> result = instance.rightSideView(n1);
		System.out.println(result);
	}
	
	/*
	 * Use code from level order traversal. Each level's right most node is stored in result list.
	 * Simpler solution here: http://www.programcreek.com/2014/04/leetcode-binary-tree-right-side-view-java/
	 */
    public List<Integer> rightSideView(TreeNode root) {
    	List<List<Integer>> inOrderList = new ArrayList<List<Integer>>();
    	List<Integer> result = new ArrayList<Integer>();
    	if(root==null){
    		return result;
    	}
    	LinkedList<TreeNode> nodeToTravel = new LinkedList<TreeNode>();
    	LinkedList<Integer> nodeLevel = new LinkedList<Integer>();
    	nodeLevel.add(1);
    	nodeToTravel.addFirst(root);

    	while(!nodeToTravel.isEmpty()){
    		TreeNode next = nodeToTravel.removeLast();
    		int level = nodeLevel.removeLast();

    		List<Integer> list;
    		if(inOrderList.size()<level){
        		list = new ArrayList<Integer>();
        		inOrderList.add(list);
        		result.add(0);
    		}else{
    			list = inOrderList.get(inOrderList.size()-1);
    		}
    		list.add(next.val);
    		result.set(level-1, next.val);
    		
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
	
	/*
	 *   
	 */
	
	

}
