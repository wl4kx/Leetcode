/**
 * 
 */
package wenxin.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 85.
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 */
public class MaximalRectangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * anaylysis from http://siddontang.gitbooks.io/leetcode-solution/content/array/maximal_rectangle.html
	 */
	/*
	 * key is to convert this 2D matrix to histogram and use method in problem "Largets Rectangle in Histogram" to solve it.
	 */
    public int maximalRectangle(char[][] matrix) {
    	if(matrix == null || matrix.length == 0) return 0;  
        int rowCount = matrix.length;  
        int columnCount = matrix[0].length;  
        int[][] rectangle = new int[rowCount][columnCount];  
        for(int i = 0; i < rowCount; i++){  
            for(int j = 0; j < columnCount;j++){  
                if(i == 0){  
                    rectangle[i][j] = matrix[i][j] == '1' ? 1 : 0;  
                }else{  
                    rectangle[i][j] = matrix[i][j] == '1' ? 1 + rectangle[i - 1][j] : 0;  
                }  
            }  
        }  
          
        int maxArea = 0;  
        for(int i = 0; i < rowCount; i++){  
            int tem = largestRectangleArea(rectangle[i]);  
            maxArea = tem > maxArea ? tem : maxArea;  
        }  
        return maxArea;  
    }
    /*
     * below method from "Largest Rectangle Area"
     */
	public int largestRectangleArea(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int maxArea = 0;
		int[] h = new int[height.length + 1];
		h = Arrays.copyOf(height, height.length + 1);
		while (i < h.length) {
			if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
				stack.push(i++);
			} else {
				int t = stack.pop();
				maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
			}
		}
		return maxArea;
	}

}
