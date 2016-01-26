/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
/*
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
 */
public class MaximalSquare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximalSquare instance = new MaximalSquare();
		char[][] matrix = new char[2][2];
		char[] ca1 = {'0','0'};
		char[] ca2 = {'0','1'};
		matrix[0] = ca1;
		matrix[1] = ca2;
		System.out.println(instance.maximalSquare(matrix));
		
	}

	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int m = matrix.length;
		int n = matrix[0].length;

		int[][] t = new int[m][n];

		// top row
		for (int i = 0; i < m; i++) {
			t[i][0] = Character.getNumericValue(matrix[i][0]);
		}

		// left column
		for (int j = 0; j < n; j++) {
			t[0][j] = Character.getNumericValue(matrix[0][j]);
		}

		// cells inside
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == '1') {
					int min = Math.min(t[i - 1][j], t[i - 1][j - 1]);
					min = Math.min(min, t[i][j - 1]);
					t[i][j] = min + 1;
				} else {
					t[i][j] = 0;
				}
			}
		}

		int max = 0;
		// get maximal length
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (t[i][j] > max) {
					max = t[i][j];
				}
			}
		}

		return max * max;
	}
    
}
