/**
 * 
 */
package wenxin.leetcode.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 40.
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, â€? , ak) must be in non-descending order. (ie, a1 â‰? a2 â‰? â€? â‰? ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
 */
public class CombinationSumII {

	/**
	 * @param args
	 */
	/*
	 * similar to CombinationSumI, which allow duplicate use of one element, whereas this problem use each element only once. 
	 */
	public static void main(String[] args) {
		CombinationSumII instance = new CombinationSumII();
		int[] candidates = {10,1,2,7,6,1,5};
		int target =  8;
		List<List<Integer>> result = instance.combinationSum2(candidates, target);
		return;

	}
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<List<Integer>> process = new ArrayList<List<Integer>>();
		ArrayList<Integer> sums = new ArrayList<Integer>();
		ArrayList<Integer> pointers = new ArrayList<Integer>();
		process.add(arr);
		sums.add(0);
		pointers.add(0);
		return dfs(process, sums, pointers, candidates, target);
	}
	
	public List<List<Integer>> dfs(List<List<Integer>> process, List<Integer> sums, List<Integer> pointers,
			int[] candidates, int target) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		while (process.size() > 0) {
			List<Integer> currentArr = process.remove(0);
			int currentSum = sums.remove(0);
			int currentPointer = pointers.remove(0);

			for (int i = currentPointer; i < candidates.length; i++) {
				int newSum = currentSum + candidates[i];
				ArrayList<Integer> newArr = new ArrayList<Integer>(currentArr);
				newArr.add(candidates[i]);
				if(newSum==target){
					Collections.sort(newArr);
					result.add(newArr);
				}else if(newSum < target){
					process.add(newArr);
					sums.add(newSum);
					pointers.add(i + 1);
				}
			}

		}
		
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		set.addAll(result);
		result.clear();
		result.addAll(set);
		return result;
	}
}
