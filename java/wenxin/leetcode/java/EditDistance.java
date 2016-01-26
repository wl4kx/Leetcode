/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
public class EditDistance {

	/**
	 * @param args
	 */
	/*
	 * problem 72.
	 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
	 */
	public static void main(String[] args) {
		String word1 = "abb";
		String word2 = "abb";
		minDistance(word1, word2);
		//System.out.println(minDistance(word1, word2));

	}

	public static int minDistance(String word1, String word2) {
		int length1 = word1.length(); //let this be height
		int length2 = word2.length(); //let this be width

//		if(length1==0)
//			return length2;
//
//		if(length2==0)
//			return length1;

		// initialize dp. +1 to include 0 length string.
		int[][] dp = new int[length1+1][length2+1];
		
		/*
		 * initialize obvious values:
		 * If one of the word1 has length 0
		 * the minimum length is obviously length of word2
		 */
		for (int i = 0; i < length1 + 1; i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i < length2 + 1; i++) {
			dp[0][i] = i;
		}

		//begin dp.
		
		for (int i = 0; i < length1; i++) {
			char c1 = word1.charAt(i);
			for (int j = 0; j < length2; j++) {
				char c2 = word2.charAt(j);
				if(c1==c2){
					dp[i+1][j+1] = dp[i][j];
				}else{
					//case insert to word1.
					int insert = dp[i+1][j] + 1;
					//case delete from word1.
					int delete = dp[i][j+1] + 1;
					//case replace in word1.
					int replace = dp[i][j] + 1;
					
					dp[i+1][j+1] = Math.min(replace, Math.min(insert, delete));
					
				}
			}
		}
		
		for(int i=0;i<length1+1;i++){
			for(int j =0;j< length2+1;j++){
				System.out.print(dp[i][j]+", ");
			}
			System.out.println("");
		}
		
		return dp[length1][length2];
		
	}
}
