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
/*
 * problem 95.
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class UniqueBinarySearchTreesII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBinarySearchTreesII instance = new UniqueBinarySearchTreesII();
		instance.generateTrees(2);
	}

    public List<TreeNode> generateTrees(int n) {
        return recurse(1, n);
    }
    
    /*
     * key: use recursion to build left and right subtree.
     */
	public List<TreeNode> recurse(int start, int end) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		if(start>end){
			result.add(null);
			return result;
		}
		if (start == end) {
			result.add(new TreeNode(start));
			return result;
		}

		for (int i = start; i <= end; i++) {

			List<TreeNode> left = recurse(start, i-1);
			List<TreeNode> right = recurse(i+1, end);
			
			if(left!=null && right!=null){
				for(TreeNode n : left){
					for(TreeNode m : right){
						TreeNode root = new TreeNode(i);
						root.left =n;
						root.right = m;
						result.add(root);
					}
				}
			}

		}
		return result;
	}
	
}
