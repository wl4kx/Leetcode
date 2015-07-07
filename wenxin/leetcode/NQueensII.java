/**
 * 
 */
package wenxin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liao.wenxin
 *
 */

/*
 * problem 52.
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
 */
public class NQueensII {
	
	public static void main(String[] args){
		System.out.println(totalNQueens(4));
	}

	public static int totalNQueens(int n) {

		List<int[]> process = new ArrayList<int[]>();
		List<Integer> processIndex = new ArrayList<Integer>();
		int[] aSolution = new int[n];
		int aIndex = 0;
		process.add(aSolution);
		processIndex.add(aIndex);

		return process(n, process, processIndex);
	}

	public static int process(int n, List<int[]> process, List<Integer> processIndex) {
		int successCount = 0;
		while (process.size() > 0) {
			int[] thisSolution = process.remove(0);
			int thisIndex = processIndex.remove(0);
			if(thisIndex==0){
				for (int i = 0; i < n; i++) {
					int[] newSolution = Arrays.copyOf(thisSolution, n);
					newSolution[0] = i;
					process.add(newSolution);
					processIndex.add(1);
				}
				if(n==1){
					successCount++;
				}
			}else{
				for (int i = 0; i < n; i++) {
					boolean pass = true;
					for (int j = 0; j < thisIndex; j++) {
						if ((thisSolution[j] == i) || (Math.abs(thisSolution[j] - i) == (thisIndex - j))) {
							pass = false;
							break;
						}
					}
					if(pass){
						int[] newSolution = Arrays.copyOf(thisSolution, n);
						newSolution[thisIndex] = i;
						if (thisIndex == (n - 1)) {
							successCount++;
						} else {
							process.add(newSolution);
							processIndex.add(thisIndex + 1);
						}
					}
				}
			}
		}
		return successCount;
	}
}
