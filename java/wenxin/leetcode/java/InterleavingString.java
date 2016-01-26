/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 97.
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
 */
public class InterleavingString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InterleavingString instance = new InterleavingString();
		String s1 = "a";
		String s2 = "b";
		String s3 = "a";
		System.out.println(instance.isInterleave(s1, s2, s3));

	}

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
		//case when s1="" and s2="" and s3=""
		dp[0][0] = true;
		// initialize
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s3.charAt(i)) {
				dp[i + 1][0] = true;
			} else {
				break;
			}
		}
		for (int i = 0; i < s2.length(); i++) {
			if (s2.charAt(i) == s3.charAt(i)) {
				dp[0][i + 1] = true;
			} else {
				break;
			}
		}

		// begin dp
		for (int i = 1; i < s1.length() + 1; i++) {
			for (int j = 1; j < s2.length() + 1; j++) {
				if (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
					dp[i][j] = true;
				}
				if (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
					dp[i][j] = true;
				}
			}
		}
		/*
		 * //print out dp for debugging.
		 * System.out.println("    0,     1,     2 ,     3 ,    4 ,   5"); for
		 * (int i = 0; i < s1.length()+1; i++) { System.out.print(i+" "); for
		 * (int j = 0; j < s2.length()+1; j++) {
		 * System.out.print(dp[i][j]+", "); } System.out.println(""); }
		 * System.out
		 * .println("");System.out.println("");System.out.println("");System
		 * .out.println("");
		 */
		return dp[s1.length()][s2.length()];

	}
}
