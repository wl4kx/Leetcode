/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 63.
 * Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
 */
public class UniquePathsII {
	
	public static void main(String[] args){
		int[] a = {0,0};
		int[] b = {1,1};
		int[] c = {0,0};
		int[][] arr= new int[3][2];
		arr[0] = a;
		arr[1] = b;
		arr[2] = c;
		//System.out.println(arr[1][2]);
		System.out.println(uniquePathsWithObstacles(arr));
	}
	
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int height = obstacleGrid.length;
        
        int[][] dp = new int[height][width];
        
        //initialize first row.
        boolean seeObstacleRow = false;
        for (int i = 0; i < width; i++) {
			if(obstacleGrid[0][i] == 1){
				seeObstacleRow = true;
			}
			if(seeObstacleRow){
				dp[0][i] = 0;
			}else{
				dp[0][i] = 1;
			}
		}
        
        if(height==1){
        	if(seeObstacleRow){
        		return 0;
        	}else{
        		return 1;
        	}
        }
        
      //initialize left most column.
        boolean seeObstacleColumn = false;
        for (int i = 0; i < height; i++) {
			if(obstacleGrid[i][0] == 1){
				seeObstacleColumn = true;
			}
			if(seeObstacleColumn){
				dp[i][0] = 0;
			}else{
				dp[i][0] = 1;
			}
		}
        
        if(width==1){
        	if(seeObstacleColumn){
        		return 0;
        	}else{
        		return 1;
        	}
        }
        
        //populate dp table.
        for (int i = 1; i < height; i++) {
			for (int j = 1; j < width; j++) {
				if(obstacleGrid[i][j]==1){
					dp[i][j] = 0;
				}else{
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
				}
			}
		}
        
        return dp[height-1][width-1];
    }
}
