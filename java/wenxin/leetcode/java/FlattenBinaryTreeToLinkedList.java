/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
public class FlattenBinaryTreeToLinkedList {

	/**
	 * @param args
	 */
	/*
	 * problem 114.
	 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
	 */
	public static void main(String[] args) {
		FlattenBinaryTreeToLinkedList instance = new FlattenBinaryTreeToLinkedList();
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		instance.flatten(n1);
		System.out.println(n1.val);
		System.out.println(n1.right.val);
		System.out.println(n1.right.right.val);
		//System.out.println(n1.right.right.val);

	}
	public TreeNode newRoot;
    public void flatten(TreeNode root) {
    	if(root==null){
    		return;
    	}
       newRoot = new TreeNode(-1);
       traverse(root);
       root = newRoot.right;
       return;
    }
    
    public void traverse(TreeNode root){
    	TreeNode leftNode = null;
    	TreeNode rightNode = null;
    	if(root!=null){
    		leftNode = root.left;
    		rightNode = root.right;
    		root.left = null;
    		root.right = null;
    		newRoot.right = root;
    		newRoot = newRoot.right;
    	}
    	if(leftNode!=null){
    		traverse(leftNode);
    	}
    	if(rightNode!=null){
    		traverse(rightNode);
    	}
    }
    
	
	
    /*
     * Another WAY!!!!!!!!!!!!!!!!! USE RECURSION. Exceeds time limit!!!!.
     *
1) Find a node N with a left child L;
2) Find the rightmost descendant of L and call it RM;
3) Aux = N.right;
4) N.right = L
5) RM.right = Aux
6) Explore the right subtree of N recursively.
     */
/*	public void flatten(TreeNode root) {
		if(root==null)
			return;
		TreeNode aux = root.right;
		if(root.left!=null){
			findRightMostChild(root.left).right = aux;
			root.right = root.left;
		}
		flatten(root.right);
		
	}
	
	public TreeNode findRightMostChild(TreeNode root){
		if(root.right!=null)
			return findRightMostChild(root.right);
		if(root.left!=null)
			return findRightMostChild(root.left);
		return root;
	}*/
	
}
