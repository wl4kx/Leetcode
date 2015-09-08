/**
 * 
 */
package wenxin.leetcode;

/**
 * @author liao.wenxin
 *
 */
/*
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class MissingNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int missingNumber(int[] nums) {
		int max = -1;
		int sum = 0;
		boolean isZeroPresent = false;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(nums[i], max);
			sum += nums[i];
			if(nums[i]==0){
				isZeroPresent = true;
			}
		}
		if(!isZeroPresent){
			return 0;
		}
		int expectedSum = (1+max) * max / 2;
		if(expectedSum==sum){
			return max+1;
		}
		return expectedSum - sum;
		
		
		
	}

}
