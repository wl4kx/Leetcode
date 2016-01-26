/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
public class MinimumPathSum {

	/**
	 * @param args
	 */
	/*
	 * problem 64.
	 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[1][4];
		int[] a = {9, 1, 4, 8};
		int[] b = {1, 1};
		arr[0] = a;
		// arr[1] = b;
		System.out.println(minPathSum(arr));
	}
	
    public static int minPathSum(int[][] grid) {
    	
    	int width = grid[0].length;
    	int height = grid.length;
    	
    	if(width==1){
    		int minSum = 0;
    		for (int i = 0; i < height; i++) {
				minSum += grid[i][0];
			}
    		return minSum;
    	}
    	if(height==1){
    		int minSum = 0;
    		for (int i = 0; i < width; i++) {
				minSum += grid[0][i];
			}
    		return minSum;
    	}
    		
    	
    	int[][] minSums = new int[height][width];
    	//initialize base cases.
    	minSums[0][0] = grid[0][0];
    	for (int i = 1; i < width; i++) {
			minSums[0][i] = minSums[0][i-1] + grid[0][i];
		}
    	for (int i = 1; i < height; i++) {
			minSums[i][0] = minSums[i-1][0] + grid[i][0];
		}
    	
    	// use dp to fill min sums grid.
    	for (int i = 1; i < height; i++) {
			for (int j = 1; j < width; j++) {
				minSums[i][j] = grid[i][j]+ Math.min(minSums[i-1][j], minSums[i][j-1]);
			}
		}
    	
    	return minSums[height-1][width-1];
    	
    }

}
