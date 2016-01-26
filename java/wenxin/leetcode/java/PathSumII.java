/**
 * 
 */
package wenxin.leetcode.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 113.
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 */
public class PathSumII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
    	dfs(root, sum, 0, result, new ArrayList<Integer>());
    	return result;
    }
    
	public void dfs(TreeNode root, int sum, int currentSum, List<List<Integer>> result, List<Integer> process) {
		if (root != null) {
			int newSum = currentSum + root.val;
			ArrayList<Integer> newProcess = new ArrayList<Integer>(process);
			newProcess.add(root.val);
			if (newSum == sum && root.left == null && root.right == null) {
				result.add(newProcess);
			} else {
				dfs(root.left, sum, newSum, result, newProcess);
				dfs(root.right, sum, newSum, result, newProcess);
			}
		}
	}

}
