/**
 * 
 */
package wenxin.leetcode.java;

import java.util.HashMap;

/**
 * @author liao.wenxin
 *
 */
public class TwoSum_ {

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
		int[] numbers = {3, 2, 4};
		int[] result = twoSum(numbers, 6);
		System.out.println(result[0]+" "+ result[1]);
	}
	
	public static int[] twoSum(int[] nums, int target) {
		int[] ret = new int[2];
		//nums length must >= 2
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(target - nums[0], 0);
		for(int i = 1; i<nums.length;i++){
			if(map.containsKey(nums[i])){
				//found
				ret[0] = map.get(nums[i]);
				ret[1] = i;
				return ret;
			}else{
				map.put(target - nums[i], i);
			}
		}
		return null;
	}
}
