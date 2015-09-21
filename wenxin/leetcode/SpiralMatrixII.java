/**
 * 
 */
package wenxin.leetcode;


/**
 * @author liao.wenxin
 *
 */
/*
 * problem 59.
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
public class SpiralMatrixII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpiralMatrixII instance = new SpiralMatrixII();
		int[][] matrix = instance.generateMatrix(3);
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(matrix[i]);
		}

	}
	
    public int[][] generateMatrix(int n) {
    	int[][] matrix = new int[n][n];
    	
    	int count = 1;
    	
    	int nextHeight = n;
    	int nextWidth = n;
     
    	//1 is for right, 2 for down, 3 for left, 4 for up.
    	//int[] directions = {1, 2, 3, 4};

    	int i=0;
    	int j=-1;
    	int direction = 1;
		while (count < n*n+1) {

			if (direction == 1) {
				int step = nextWidth;
				j++;
				while (step>0) {
					matrix[i][j] = count;
					j++;
					step--;
					count++;
				}
				nextHeight--;
				j--;
				direction = 2;
			} else if (direction == 2) {
				int step = nextHeight;
				i++;
				while (step>0) {
					matrix[i][j] = count;
					i++;
					step--;
					count++;
				}
				nextWidth--;
				i--;
				direction = 3;
			} else if (direction == 3) {
				int step = nextWidth;
				j--;
				while (step>0) {
					matrix[i][j] = count;
					j--;
					step--;
					count++;
				}
				nextHeight--;
				j++;
				direction = 4;
			} else if (direction == 4) {
				int step = nextHeight;
				i--;
				while (step>0) {
					matrix[i][j] = count;
					i--;
					step--;
					count++;
				}
				nextWidth--;
				i++;
				direction = 1;
			}
		}
    	
    	
    	return matrix;
    
    }
}
