/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 115.
 * Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
 */
public class DistinctSubsequences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DistinctSubsequences instance = new DistinctSubsequences();
		System.out.println(instance.numDistinct("aaa","aa"));

	}

	public int numDistinct(String s, String t) {

		if(s.length()<t.length()){
			return 0;
		}
		
		int[][] dp = new int[s.length() + 1][t.length() + 1];

		// initialize
		for (int i = 0; i < s.length(); i++) {
			dp[i][0] = 1;
		}

		for (int j = 1; j < t.length() + 1; j++) {
			for (int i = 1; i < s.length() + 1; i++) {
				if (s.charAt(i-1) == t.charAt(j-1)) {
					dp[i][j] =dp[i-1][j] + dp[i-1][j-1];
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		return dp[s.length()][t.length()];
		
	}
}
