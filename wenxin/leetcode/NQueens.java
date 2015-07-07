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
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */
public class NQueens {
	
	public static void main(String[] args){
//		int[] solution = {2, 0, 3, 1};
//		ArrayList<int[]> result = new ArrayList<int[]>();
//		result.add(solution);
		List<List<String>> transformed = solveNQueens(2);

		for(List<String> sample : transformed){
			System.out.println(sample);
		}
	}

	public static List<List<String>> solveNQueens(int n) {
		List<int[]> result = new ArrayList<int[]>();
		List<int[]> process = new ArrayList<int[]>();
		List<Integer> processIndex = new ArrayList<Integer>();
		int[] aSolution = new int[n];
		int aIndex = 0;
		process.add(aSolution);
		processIndex.add(aIndex);
		process(n, process, processIndex, result);
		
		return transformResult(result, n);
	}

	public static void process(int n, List<int[]> process, List<Integer> processIndex, List<int[]> result) {

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
					result.add(process.get(0));
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
							result.add(newSolution);
						} else {
							process.add(newSolution);
							processIndex.add(thisIndex + 1);
						}
					}
				}
			}
		}

	}
	/*
	 * use array of n to represent a solution.
	 * for example, for [".Q..",  // Solution 1
  						 "...Q",
  						 "Q...",
  						 "..Q."],
  		should be represented as [1, 3, 0, 2];
  		Follow method translate array back to what problem wants.
	 */
	public static ArrayList<List<String>> transformResult(List<int[]> result, int n){
		ArrayList<List<String>> result_transformed =new ArrayList<List<String>>();
		for (int[] solution : result) {
			ArrayList<String> aList = new ArrayList<String>();
			for (int i = 0; i < n; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < n; j++) {
					if(solution[i]!=j){
						sb.append(".");
					}else{
						sb.append("Q");
					}
				}
				aList.add(sb.toString());
			}
			result_transformed.add(aList);
		}
		return result_transformed;
	}
}
