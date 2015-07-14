/**
 * 
 */
package wenxin.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author liao.wenxin
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {

	/**
	 * @param args
	 */
	/*
	 * problem 103.
	 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
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
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		
		TreeNode node1 = new TreeNode(9);
		TreeNode node2 = new TreeNode(20);
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(7);
		//TreeNode node5 = new TreeNode(1);
		root.left = node1;
		root.right = node2;
		node2.left = node3;
		node2.right = node4;
		
		List<List<Integer>> result = zigzagLevelOrder(root);
		for(List<Integer> list : result){
			for(int i : list){
				System.out.print(i+"-> ");
			}
			System.out.println("");
		}

	}
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> result = new LinkedList<List<Integer>>();
    	if(root==null){
    		return result;
    	}
    	Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    	
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	LinkedList<Integer> levels = new LinkedList<Integer>();
    	
    	queue.add(root);
    	levels.add(0);
    	while(queue.size()>0){
    		TreeNode node = queue.removeLast();
    		int level = levels.removeLast();
			List<Integer> list = map.get(level);
    		if(list!=null){
    			if(level%2==0){
    				//left to right
    				list.add(node.val);
    			}else{
    				//right to left
    				list.add(0, node.val);
    			}
    		}else{
    			List<Integer> newList = new LinkedList<Integer>();
    			newList.add(node.val);
    			map.put(level, newList);
    		}
    		
    		if(node.left!=null){
    			queue.add(0, node.left);
    			levels.add(0, level + 1);
    		}
    		
    		if(node.right!=null){
    			queue.add(0, node.right);
    			levels.add(0, level + 1);
    		}
    	}
    	
    	for(int i = 0; i< map.keySet().size();i++){
    		result.add(map.get(i));
    	}
    	
    	return result;
        
    }

}
