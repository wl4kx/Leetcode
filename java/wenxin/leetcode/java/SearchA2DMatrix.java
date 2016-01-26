/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
public class SearchA2DMatrix {

	/**
	 * @param args
	 */
	/*
	 * problem 74.
	 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
	 */
	public static void main(String[] args) {
		int[][] arr = new int[3][1];
		int[] a = {1};
		int[] b = {3};
		int[] c = {5};
		arr[0] = a;
		arr[1] = b;
		arr[2] = c;
		System.out.println(searchMatrix(arr, 1));

	}
    public static boolean searchMatrix(int[][] matrix, int target) {
	     
    	int height = matrix.length;
    	int width = matrix[0].length;
    	
    	//first, find correct row.
    	int row = -1;
    	
    	int startRow = 0;
    	int endRow = height-1;
    	while(true){
    		if(startRow==endRow){
    			row = startRow;
    			break;
    		}
    		int middleIndex = (startRow + endRow)/2;
    		int middle = matrix[middleIndex][0];
    		if(middle==target){
    			return true;
    		}else if(middle>target){
    			if(middleIndex-1>=0){
    				endRow = middleIndex-1;	
    			}else{
    				return false;
    			}
    		}else/*middle<target*/{
    			startRow = middleIndex;
    			if(endRow-startRow==1){
    				if(matrix[endRow][0]<=target){
    					row = endRow;
    				}else
    					row = startRow;
    				break;
    			}
    		}
    	}
    	
    	int startIndex = 0;
    	int endIndex = width-1;
    	int[] theRow = matrix[row];
    	while(startIndex<=endIndex){
    		int middleIndex = (startIndex+endIndex)/2;
    		int middle = theRow[middleIndex];
    		
    		if(middle == target){
    			return true;
    		}if(middle > target){
    			endIndex = middleIndex - 1;
    		}else{
    			startIndex = middleIndex + 1;
    		}
    		
    	}
    	return false;		
    	
    }
}

