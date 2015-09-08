/**
 * 
 */
package wenxin.leetcode;

/**
 * @author liao.wenxin
 *
 */
/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[	
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
 */
public class SearchA2DMatrixII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//key: search from top right to bottom left. because given each row and column is sorted.
	public boolean searchMatrix(int[][] matrix, int target) {
		if (null == matrix || matrix.length == 0) {
			return false;
		}
		int row = matrix.length - 1;
		int col = 0;
		while (row >= 0 && col < matrix[0].length) {
			if (matrix[row][col] == target) {
				return true;
			} else if (matrix[row][col] < target) {
				col++;
			} else {
				row--;
			}
		}
		return false;
	}

}
