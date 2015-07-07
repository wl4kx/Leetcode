/**
 * 
 */
package wenxin.leetcode;

/**
 * @author liao.wenxin
 *
 */

/*
 * problem 53. Find the contiguous subarray within an array (containing at least
 * one number) which has the largest sum.
 * 
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray
 * [4,−1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {
	
	public static void main(String[] args){
		int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(maxSubArray(arr));
		
	}
	
	public static int maxSubArray(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		
		//int[] maxes = new int[nums.length];	
		int maxOfMax = nums[0];
		int currentSum = nums[0];
		
		for (int i = 1; i < nums.length; i++) {

			
			currentSum=Math.max(currentSum+nums[i],nums[i]);
			maxOfMax= Math.max(maxOfMax, currentSum);
			
		}
		
		return maxOfMax;
	}
}
