/**
 * 
 */
package wenxin.leetcode;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 96.
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class UniqueBinarySearchTrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBinarySearchTrees instance = new UniqueBinarySearchTrees();
		System.out.println(instance.numTrees(3));
	}

	/*
	 * use dp, dp[i] represents how many unique binary there is for i nodes.
	 */
    public int numTrees(int n) {
    	if(n==0){
    		return 0;
    	}
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= i-1; j++) {
				int left = j;
				int right = i-j-1;
				dp[i] += dp[left] * dp[right];
			}
		}     
        
        return dp[n];
    }
	
}
