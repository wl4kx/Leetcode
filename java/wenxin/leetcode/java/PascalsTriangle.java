/**
 * 
 */
package wenxin.leetcode.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 118.
 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
public class PascalsTriangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalsTriangle instance = new PascalsTriangle();
		instance.generate(3);
	}

	public List<List<Integer>> generate(int numRows) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(numRows==0){
			return result;
		}
		List<Integer> firstRow = new ArrayList<Integer>();
		firstRow.add(1);
		result.add(firstRow);

		for (int i = 2; i <= numRows; i++) {
			List<Integer> row = new ArrayList<Integer>();
			row.add(1);
			for(int j=1;j<i-1;j++){

				row.add( result.get(i-2).get(j-1)+result.get(i-2).get(j));
			}
			row.add(1);			
			result.add(row);
		}

		return result;

	}
}
