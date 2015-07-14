/**
 * 
 */
package wenxin.leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * @author liao.wenxin
 *
 */
public class BinaryTreeInorderTraversal {

	/**
	 * @param args
	 */
	/*
	 * problem 94.
	 * Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

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
		TreeNode root = new TreeNode(1);
		
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(1);
		root.right = node1;
		node1.left = node2;
		
		List<Integer> result = inorderTraversal(root);
		for(int i : result){
			System.out.print(i + "-> ");
		}
		

	}

    public static List<Integer> inorderTraversal(TreeNode root) {
    	ArrayList<Integer> result  = new ArrayList<Integer>();  
    	traverse(root, result);
    	
    	return result;
        
    }
    
    public static void traverse(TreeNode root, ArrayList<Integer> result){
    	if(root==null)
    		return;
    	if(root.left!=null)
    		traverse(root.left, result);
    	result.add(root.val);
    	if(root.right!=null)
    		traverse(root.right, result);
    }
    
}
