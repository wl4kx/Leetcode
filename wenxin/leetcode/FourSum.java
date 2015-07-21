/**
 * 
 */
package wenxin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 18.
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
 */
public class FourSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {1, 0, -1, 0, -2, 2};
		System.out.println(fourSum(nums, 0).toString());

	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);

		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length - 3; i++) {
			for (int j =  i+1; j < nums.length - 2; j++) {
				//from here it's two sum problem.
				int iv = nums[i];
				int jv = nums[j];
				int twoSumTarget = target - iv - jv;
				
				int start = j+1;
				int end = nums.length - 1;
				
				while(start<end){
					int sv = nums[start];
					int ev = nums[end];
					int twoSum = sv + ev;
					if(twoSum==twoSumTarget){
						ArrayList<Integer> result = new ArrayList<Integer>();
						result.add(iv);
						result.add(jv);
						result.add(sv);
						result.add(ev);
						set.add(result);
						end--;
						start++;
					}else if(twoSum>twoSumTarget){
						end--;
					}else{
						start++;
					}
				}
				
			}
		}
		results.addAll(set);
		return results;
	}
}
