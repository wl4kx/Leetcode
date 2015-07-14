/**
 * 
 */
package wenxin.leetcode;

/**
 * @author liao.wenxin
 *
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

	/**
	 * @param args
	 */
	/*
	 * problem 106.
	 * Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
	 */
	public static void main(String[] args) {
		int [] postorder = {1, 2};
		int [] inorder = {1, 2};
		TreeNode node = buildTree(postorder, inorder);
		System.out.println(node.val);
		System.out.println(node.left.val);
		//System.out.println(node.right.val);

	}
	
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
    	if(postorder.length==0 || inorder.length == 0)
    		return null;
    	
    	return findLeftAndRightChildren(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1);
    }
    
    public static TreeNode findLeftAndRightChildren(int[] postorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd){
    	
    	if(iStart>iEnd){
    		return null;
    	}
    	int value = postorder[pEnd];
    	TreeNode root = new TreeNode(value);
    	//find index of root in postorder array.
    	int index = -1;
    	for(int i=iStart; i<= iEnd; i++){
    		if(inorder[i] == value){
    			index = i;
    			break;
    		}
    	}
    	
    	// int numberOfNodesInLeftTree = index - iStart;
    	int numberOfNodesInRightTree = iEnd - index;
    	
    	root.right = findLeftAndRightChildren(postorder, pEnd - numberOfNodesInRightTree, pEnd - 1, inorder, index + 1, iEnd);
    	root.left = findLeftAndRightChildren(postorder, pStart, pEnd - numberOfNodesInRightTree - 1, inorder, iStart, index-1);
    	
    	
		return root;
    	
    }

}
