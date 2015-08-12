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
 * problem 119.
 * Given an index k, return the kth row of the Pascal's triangle.
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangleII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalsTriangleII instance = new PascalsTriangleII();
		instance.getRow(2);
	}
	
    public List<Integer> getRow(int rowIndex) {

		List<Integer> row1 = new ArrayList<Integer>();
		List<Integer> row2 = new ArrayList<Integer>();
		
		row1.add(1);
    	if(rowIndex ==0){
    		return row1;
    	}
		for (int i = 1; i <= rowIndex; i++) {
			row2.clear();
			row2.add(1);
			for(int j=1;j<i;j++){
				row2.add(row1.get(j-1) + row1.get(j));
			}
			row2.add(1);	
			
			row1 = new ArrayList<Integer>(row2);

		}

		return row1;
    }

}
