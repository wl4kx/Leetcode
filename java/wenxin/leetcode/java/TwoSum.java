/**
 * 
 */
package wenxin.leetcode.java;

import java.util.HashMap;

/**
 * @author liao.wenxin
 *
 */
public class TwoSum {

	/**
	 * @param args
	 */
	/*
	 * problem 1.
	 * Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {2, 7, 11, 15};
		int[] result = twoSum(numbers, 9);
		System.out.println(result[0]+" "+ result[1]);
	}
	
	public static int[] twoSum(int[] nums, int target) {
		// use map. time complexity is O(n).

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int v = nums[i];
			int want = target - v;
			if(map.containsKey(want)){
				if(i+1>map.get(want)){
					result[1] = i+1;
					result[0] = map.get(want)+1;
				}else{
					result[0] = i+1;
					result[1] = map.get(want)+1;
				}

				return result;
			}
			map.put(v, i);
		}
		return result;
	}
}
