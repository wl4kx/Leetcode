/**
 * 
 */
package wenxin.leetcode;

import java.util.LinkedList;

/**
 * @author liao.wenxin
 *
 */
public class PopulatingNextRightPointersInEachNode {

	/**
	 * @param args
	 */
	/*
	 * problem 116.
	 * Given a binary tree


 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
	 */
	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode n1 = new TreeLinkNode(2);
		TreeLinkNode n2 = new TreeLinkNode(3);
		root.left = n1;
		root.right = n2;
		connect(root);
		System.out.println(root.left.next.val);
	}
    public static void connect(TreeLinkNode root) {
    	
    	if(root == null){
    		return;
    	}
    	
    	LinkedList<TreeLinkNode> pointers = new LinkedList<TreeLinkNode>();
    	LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
    	LinkedList<Integer> levels = new LinkedList<Integer>();
    	queue.add(root);
    	levels.add(0);
    	
    	while(queue.size()>0){
    		TreeLinkNode node = queue.removeLast();
    		Integer level = levels.removeLast();
    		
    		TreeLinkNode pointer;
    		if(pointers.size()<=level){
    			pointer = new TreeLinkNode(-1);
    			pointers.add(pointer);
    		}
    		pointer = pointers.get(level);
    		pointers.remove(level.intValue());
    		pointer.next = node;
    		pointers.add(node);
    		
    		if(node.left != null){
    			queue.addFirst(node.left);
    			levels.addFirst(level+1);
    		}
    		
    		if(node.right != null){
    			queue.addFirst(node.right);
    			levels.addFirst(level+1);
    		}
    	}
    	
    	
    }
}
