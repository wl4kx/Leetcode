package wenxin.leetcode.java;
import java.util.LinkedList;

import wenxin.leetcode.java.TreeNode;

/*
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeAndDeserializeBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SerializeAndDeserializeBinaryTree s = new SerializeAndDeserializeBinaryTree();
		Codec instance = s.new Codec();
		
		TreeNode root = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(4);
		TreeNode n4 = new TreeNode(5);
		
		root.left = n1;
		root.right = n2;
		n2.left = n3;
		n2.right = n4;
		
		String result = instance.serialize(root);
		TreeNode desed = instance.deserialize(result);
		String result2 = instance.serialize(desed);
		System.out.println(result2);
	}

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public class Codec {
		
	    // Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
	    	if(root==null){
	    		return null;
	    	}
	    	LinkedList<TreeNode> queue = new LinkedList<>();
	    	queue.add(root);
	    	StringBuilder sb = new StringBuilder();
	    	while(!queue.isEmpty()){
	    		TreeNode cur = queue.removeFirst();
	    		if(cur==null){
	    			sb.append("null,");
	    		}else{
	    			sb.append(cur.val+",");	
	    			queue.add(cur.left);
	    			queue.add(cur.right);
	    		}
	    	}
	    	return sb.subSequence(0, sb.length()-1).toString();
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	    	if(data==null || data.equals("")){
	    		return null;
	    	}
	    	String[] sa = data.split(",");
	    	LinkedList<TreeNode> queue = new LinkedList<>();
	    	TreeNode root = new TreeNode(Integer.parseInt(sa[0]));
	    	queue.add(root);
	    	for (int i = 1; i < sa.length; i++) {
	    		TreeNode cur;
	    		TreeNode croot = queue.removeFirst();
	    		if(!sa[i].equals("null")){
	    			cur = new TreeNode(Integer.parseInt(sa[i]));
	    			queue.add(cur);

	    		}else{
	    			cur = null;
	    		}
    			croot.left = cur;
	    		i++;
	    		if(!sa[i].equals("null")){
	    			cur = new TreeNode(Integer.parseInt(sa[i]));
	    			queue.add(cur);
	    		}else{
	    			cur = null;
	    		}
    			croot.right = cur;
			}
	        return root;
	    }
	}

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.deserialize(codec.serialize(root));
}
