package wenxin.leetcode.java;

import java.util.HashSet;
/*
 * problem 73.
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 */
public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {

		HashSet<Integer> rowSet = new HashSet<Integer>();
		HashSet<Integer> columnSet = new HashSet<Integer>();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					rowSet.add(i);
					columnSet.add(j);
				}
			}
		}

		for (Integer r : rowSet) {
			for (int i = 0; i < matrix[r].length; i++) {
				matrix[r][i] = 0;
			}
		}

		for (Integer c : columnSet) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][c] = 0;
			}
		}

	}
}
