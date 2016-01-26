/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	/**
	 * @param args
	 */
	/*
	 * problem 105.
	 * Given preorder and inorder traversal of a tree, construct the binary tree.
	 * Note:
You may assume that duplicates do not exist in the tree.
	 */
	public static void main(String[] args) {
		int [] preorder = {1, 2};
		int [] inorder = {1, 2};
		TreeNode node = buildTree(preorder, inorder);
		System.out.println(node.val);
		//System.out.println(node.left.val);
	System.out.println(node.right.val);
		

	}
	
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
    	
    	if(preorder.length==0 || inorder.length == 0)
    		return null;
    	
    	return findLeftAndRightChildren(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    	
    }
    
    public static TreeNode findLeftAndRightChildren(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd){
    	
    	if(iStart>iEnd){
    		return null;
    	}
    	int value = preorder[pStart];
    	TreeNode root = new TreeNode(value);
    	//find index of root in inorder array.
    	int index = -1;
    	for(int i=iStart; i<= iEnd; i++){
    		if(inorder[i] == value){
    			index = i;
    			break;
    		}
    	}
    	
    	int numberOfNodesInLeftTree = index - iStart;
    	// int numberOfNodesInRightTree = iEnd - index;
    	
    	root.left = findLeftAndRightChildren(preorder, pStart+1, pStart + numberOfNodesInLeftTree, inorder, iStart, index-1);
    	root.right = findLeftAndRightChildren(preorder, pStart + 1+ numberOfNodesInLeftTree , pEnd, inorder, index + 1, iEnd);
    	
    	
		return root;
    	
    }

}
