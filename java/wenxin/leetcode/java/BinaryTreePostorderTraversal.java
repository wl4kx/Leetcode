package wenxin.leetcode.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePostorderTraversal {

	public static void main(String[] args) {
		BinaryTreePostorderTraversal instance = new BinaryTreePostorderTraversal();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		
		n1.left = n2;
		n1.right = n3;
		
		System.out.println(instance.postorderTraversal2(n1));

	}

	public List<Integer> postorderTraversal(TreeNode root) {

		List<Integer> result = new LinkedList<Integer>();

		if(root==null){
			return result;
		}
		
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		Stack<Boolean> leftStack = new Stack<Boolean>();
		Stack<Boolean> rightStack = new Stack<Boolean>();

		nodeStack.push(root);
		leftStack.push(false);
		rightStack.push(false);

		while (!nodeStack.isEmpty()) {
			TreeNode curNode = nodeStack.pop();
			boolean visitedRight = rightStack.pop();
			boolean visitedLeft = leftStack.pop();

			if (curNode.left == null && curNode.right == null || (visitedRight && visitedLeft)) {
				result.add(curNode.val);
			} else {
				
				nodeStack.push(curNode);
				leftStack.push(true);
				rightStack.push(true);

				if (curNode.right != null && !visitedRight) {
					nodeStack.push(curNode.right);
					leftStack.push(false);
					rightStack.push(false);
				}

				if (curNode.left != null && !visitedLeft) {
					nodeStack.push(curNode.left);
					leftStack.push(false);
					rightStack.push(false);
				}

			}
		}

		return result;
		
	}
	
	/*
	 * solution from http://www.programcreek.com/2012/12/leetcode-solution-of-iterative-binary-tree-postorder-traversal-in-java/
	 *  that only uses one stack.
	 */
	public List<Integer> postorderTraversal2(TreeNode root){

        ArrayList<Integer> lst = new ArrayList<Integer>();
 
        if(root == null)
            return lst; 
 
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
 
        TreeNode prev = null;
        while(!stack.empty()){
            TreeNode curr = stack.peek();
 
            // go down the tree.
            //check if current node is leaf, if so, process it and pop stack,
            //otherwise, keep going down
            if(prev == null || prev.left == curr || prev.right == curr){
                //prev == null is the situation for the root node
                if(curr.left != null){
                    stack.push(curr.left);
                }else if(curr.right != null){
                    stack.push(curr.right);
                }else{
                    stack.pop();
                    lst.add(curr.val);
                }
 
            //go up the tree from left node    
            //need to check if there is a right child
            //if yes, push it to stack
            //otherwise, process parent and pop stack
            }else if(curr.left == prev){
                if(curr.right != null){
                    stack.push(curr.right);
                }else{
                    stack.pop();
                    lst.add(curr.val);
                }
 
            //go up the tree from right node 
            //after coming back from right node, process parent node and pop stack. 
            }else if(curr.right == prev){
                stack.pop();
                lst.add(curr.val);
            }
 
            prev = curr;
        }
 
        return lst;
	}
	
}
