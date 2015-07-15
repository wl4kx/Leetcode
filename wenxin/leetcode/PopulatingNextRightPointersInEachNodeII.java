/**
 * 
 */
package wenxin.leetcode;

import java.util.LinkedList;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 117. It happened that my solution to 116 can solve this too.
 * Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 */
public class PopulatingNextRightPointersInEachNodeII {
	 public void connect(TreeLinkNode root) {
	    	
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
