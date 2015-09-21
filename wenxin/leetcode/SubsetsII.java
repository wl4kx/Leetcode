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
 * problem 90.
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
public class SubsetsII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SubsetsII instance = new SubsetsII();
	   	int[] S = {2, 2, 2};
    	System.out.println(instance.subsetsWithDup(S));

	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		if (nums == null)
			return null;

		Arrays.sort(nums);

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();

		for (int i = nums.length - 1; i >= 0; i--) {

			// get existing sets
			if (i == nums.length - 1 || nums[i] != nums[i + 1] || prev.size() == 0) {
				prev = new ArrayList<ArrayList<Integer>>();
				for (int j = 0; j < result.size(); j++) {
					prev.add(new ArrayList<Integer>(result.get(j)));
				}
			}

			// add current number to each element of the set
			for (ArrayList<Integer> temp : prev) {
				temp.add(0, nums[i]);
			}

			// add each single number as a set, only if current element is
			// different with previous
			if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(nums[i]);
				prev.add(temp);
			}

			// add all set created in this iteration
			for (ArrayList<Integer> temp : prev) {
				result.add(new ArrayList<Integer>(temp));
			}
		}

		// add empty set
		result.add(new ArrayList<Integer>());

		return result;
		}
    
}
