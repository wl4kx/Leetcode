/**
 * 
 */
package wenxin.leetcode.java;

import java.util.ArrayList;


/**
 * @author liao.wenxin
 *
 */
/*
 * problem 120.
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Triangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * Key, start from bottom up.
	 */
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int[] total = new int[triangle.size()];
		int l = triangle.size() - 1;
	 
		for (int i = 0; i < triangle.get(l).size(); i++) {
			total[i] = triangle.get(l).get(i);
		}
	 
		// iterate from last second row
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) {
				total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]);
			}
		}
	 
		return total[0];
	}
/*	TIME LIMIT EXCEEDED.
 * 
 *     public int minimumTotal(List<List<Integer>> triangle) {
    	
    	if(triangle.isEmpty()){
    		return 0;
    	}
    	if(triangle.size()==1){
    		return triangle.get(0).get(0);
    	}
    	
        int[] minSum = new int[1];
        minSum[0] = Integer.MAX_VALUE;
        dfs(triangle, 1, 0, triangle.get(0).get(0), minSum);
        return minSum[0];
    }

	public void dfs(List<List<Integer>> triangle, int depth, int index, int sum, int[] minSum) {
		if (triangle.size() > depth) {
			int newSum = sum + triangle.get(depth).get(index);
			int newSum2 = sum + triangle.get(depth).get(index + 1);
			if (depth == triangle.size() - 1) {
				minSum[0] = Math.min(newSum, minSum[0]);
				minSum[0] = Math.min(newSum2, minSum[0]);
			}
			dfs(triangle, depth + 1, index, newSum, minSum);
			dfs(triangle, depth + 1, index + 1, newSum2, minSum);

		}
	}
    */
}
