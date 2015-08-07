/**
 * 
 */
package wenxin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 54.
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpiralMatrix instance = new SpiralMatrix();
		int[][] matrix = new int[4][4];
		int[] r1 = {1, 2, 3, 4};
		int[] r2 = {12, 13, 14, 5};
		int[] r3 = {11, 16, 15, 6};
		int[] r4 = {10, 9, 8, 7};
		matrix[0] = r1;
		matrix[1] = r2;
		matrix[2] = r3;
		matrix[3] = r4;
		
		List<Integer> result = instance.spiralOrder(matrix);
		System.out.println(result);

	}
	
    public List<Integer> spiralOrder(int[][] matrix) {
    	
    	List<Integer> result = new ArrayList<Integer>();
    	
    	int height = matrix.length;
    	if(height==0){
    		return result;
    	}
    	int width = matrix[0].length;
    	
    	int count = height * width;
    	
    	int nextHeight = height;
    	int nextWidth = width;
     
    	//1 is for right, 2 for down, 3 for left, 4 for up.
    	//int[] directions = {1, 2, 3, 4};

    	int i=0;
    	int j=-1;
    	int direction = 1;
		while (count > 0) {

			if (direction == 1) {
				int step = nextWidth;
				j++;
				while (step>0) {
					result.add(matrix[i][j]);
					j++;
					step--;
					count--;
				}
				nextHeight--;
				j--;
				direction = 2;
			} else if (direction == 2) {
				int step = nextHeight;
				i++;
				while (step>0) {
					result.add(matrix[i][j]);
					i++;
					step--;
					count--;
				}
				nextWidth--;
				i--;
				direction = 3;
			} else if (direction == 3) {
				int step = nextWidth;
				j--;
				while (step>0) {
					result.add(matrix[i][j]);
					j--;
					step--;
					count--;
				}
				nextHeight--;
				j++;
				direction = 4;
			} else if (direction == 4) {
				int step = nextHeight;
				i--;
				while (step>0) {
					result.add(matrix[i][j]);
					i--;
					step--;
					count--;
				}
				nextWidth--;
				i++;
				direction = 1;
			}
		}
    	
    	
    	return result;
    }

}
