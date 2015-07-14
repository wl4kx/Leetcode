/**
 * 
 */
package wenxin.leetcode;

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
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		flatten(n1);
		System.out.println(n1.val);
		System.out.println(n1.right.val);
		System.out.println(n1.right.right.val);
		//System.out.println(n1.right.right.val);

	}
	public static TreeNode newRoot;
    public static void flatten(TreeNode root) {
    	if(root==null){
    		return;
    	}
       newRoot = new TreeNode(-1);
       traverse(root);
       root = newRoot.right;
       return;
    }
    
    public static void traverse(TreeNode root){
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
     * A BETTER WAY!!!!!!!!!!!!!!!!! USE RECURSION. IMPLEMENT LATER.
     *
1) Find a node N with a left child L;
2) Find the rightmost descendant of L and call it RM;
3) Aux = N.right;
4) N.right = L
5) RM.right = Aux
6) Explore the right subtree of N recursively.
     */
}
