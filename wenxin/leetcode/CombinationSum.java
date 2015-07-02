/**
 * 
 */
package wenxin.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liao.wenxin
 *
 */

/*
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤
 * … ≤ ak). The solution set must not contain duplicate combinations. For
 * example, given candidate set 2,3,6,7 and target 7, A solution set is: [7] [2,
 * 2, 3]
 */
public class CombinationSum {
	
	public static void main(String[] args){
		int[] candidates = {92,71,89,74,102,91,70,119,86,116,114,106,80,81,115,99,117,93,76,77,111,110,75,104,95,112,94,73};
		int target =  310;
		List<List<Integer>> result = combinationSum(candidates, target);
		return;
	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<List<Integer>> process = new ArrayList<List<Integer>>();
		ArrayList<Integer> sums = new ArrayList<Integer>();
		ArrayList<Integer> pointers = new ArrayList<Integer>();
		process.add(arr);
		sums.add(0);
		pointers.add(0);
		return dfs(process, sums, pointers, candidates, target);
	}
	
	public static List<List<Integer>> dfs(List<List<Integer>> process, List<Integer> sums, List<Integer> pointers,
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
					pointers.add(i);
				}
			}

		}

		return result;
	}

/*	public static List<List<Integer>> dfs(List<List<Integer>> process, List<Integer> sums, List<Integer> pointers, int[] candidates, int target) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		while (process.size() > 0) {
			List<Integer> currentArr = process.remove(0);
			int currentSum = sums.remove(0);
			int currentPointer = pointers.remove(0);
			if(currentSum==target){
				result.add(currentArr);
			}else if(currentSum<target){
				for (int i = currentPointer; i < candidates.length; i++) {
					ArrayList<Integer> newArr = new ArrayList<Integer>(currentArr);
					newArr.add(candidates[i]);
					process.add(newArr);
					int newSum = currentSum + candidates[i];
					sums.add(newSum);
					pointers.add(i);
				}
			}
		}

		return result;
	}*/
}
