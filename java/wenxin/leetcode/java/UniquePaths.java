/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 62.
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * 
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 * 
 * Note: m and n will be at most 100.
 */
public class UniquePaths {
	public static void main(String[] args){
		System.out.println(uniquePaths(10, 10));
	}
	
	public static int uniquePaths(int m, int n) {
// 纯数学方�?
//		if(m==1 || n ==1){
//			return 1;
//		}
//		m--;
//		n--;
//		int smaller = Math.min(m, n);
//		double dividend = 1;
//		double divisor = 1;
//		for (int i = 1; i <= smaller; i++) {
//			divisor = divisor * i;
//			dividend = dividend * (m+n-i+1);
//		}
//		return (int) (dividend/divisor);
		//=====================================
//用dp的方�?
		    if(m==0 || n==0) return 0;
		    if(m==1 || n==1) return 1;
		 
		    int[][] dp = new int[m][n];
		 
		  //只有�?行时，到终点每个格子只有�?种走�?  
		    for(int i=0; i<m; i++){
		        dp[i][0] = 1;
		    }
		 
		    // 只有�?列时，到终点每个格子只有�?种走�?
		    for(int j=0; j<n; j++){
		        dp[0][j] = 1;
		    }
		 
		    //fill up the dp table
		    for(int i=1; i<m; i++){
		        for(int j=1; j<n; j++){
		            dp[i][j] = dp[i-1][j] + dp[i][j-1];
		        }
		    }
		 
		    return dp[m-1][n-1];
		}
	
}
