package wenxin.leetcode.java;

/*
 * Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */
public class LongestIncreasingPathInAMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums = { 
				{ 9, 9, 4 }, 
				{ 6, 6, 8 }, 
				{ 2, 1, 1 } 
				};
		LongestIncreasingPathInAMatrix instance = new LongestIncreasingPathInAMatrix();
		System.out.println(instance.longestIncreasingPath(nums));
	}

	private int[][] matrix;
	private int[][] dp;
	public int longestIncreasingPath(int[][] matrix) {
		int height = matrix.length;
		if(height==0){
			return 0;
		}
		int length = matrix[0].length;
		
		this.matrix = matrix;
		int max = -1;
		dp = new int[height][length];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < length; j++) {
				if(dp[i][j]==0){
					max = Math.max(max, findMax(i, j));	
				}
			}
		}
		return max;
	}
	
	private int findMax(int i, int j) {
		int a = 0, b = 0, c = 0, d = 0;
		// up
		if (isWithinRange(i - 1, j) && matrix[i][j] < matrix[i - 1][j]) {
			if (dp[i - 1][j] == 0) {
				a = findMax(i - 1, j);
				dp[i - 1][j] = a;
			} else {
				a = dp[i - 1][j];
			}

		}
		// left
		if (isWithinRange(i, j - 1) && matrix[i][j] < matrix[i][j - 1]) {

			if (dp[i][j - 1] == 0) {
				b = findMax(i, j - 1);
				dp[i][j - 1] = b;
			} else {
				b = dp[i][j - 1];
			}
		}
		// down
		if (isWithinRange(i + 1, j) && matrix[i][j] < matrix[i + 1][j]) {

			if (dp[i + 1][j] == 0) {
				c = findMax(i + 1, j);
				dp[i + 1][j] = c;
			} else {
				c = dp[i + 1][j];
			}
		}
		// right
		if (isWithinRange(i, j + 1) && matrix[i][j] < matrix[i][j + 1]) {

			if (dp[i][j + 1] == 0) {
				d = findMax(i, j + 1);
				dp[i][j + 1] = d;
			} else {
				d = dp[i][j + 1];
			}
		}
		dp[i][j] = 1 + Math.max(Math.max(a, b), Math.max(c, d));
		return dp[i][j];
	}

	private boolean isWithinRange(int i, int j) {
		return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
	}
	
}
