package wenxin.leetcode;
/*
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		LongestIncreasingSubsequence instance = new LongestIncreasingSubsequence();
		System.out.println(instance.lengthOfLIS(nums));
	}
	
	public int lengthOfLIS(int[] nums) {
		int lis = 0;
		if (nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		for (int i = nums.length - 1; i >= 0; i--) {
			int temp = 1;
			for (int j = i + 1; j < nums.length; j++) {
				if(nums[j]>nums[i]){
					temp = Math.max(temp, 1 + dp[j]);
				}
			}
			dp[i] = temp;
		}
		
		for (int i = 0; i < dp.length; i++) {
			lis = Math.max(lis, dp[i]);
		}
		
		return lis;
	}

}
