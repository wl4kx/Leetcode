/**
 * 
 */
package wenxin.leetcode;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 41.
 * Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissingPositive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * Idea is bucket sort:
	 * Correct order should be nums[i] = i; 
	 * index 0, 1, 2, 3
	 * value ?, 1, 2, 3
	 * If it A[i] doens't match i,
	 * Swap A[i] with A[A[i]].
	 */
	
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
		for (int i = 0; i < n; i++) {
			while (nums[i] != i + 1) {
				if (nums[i] <= 0 || nums[i] >= n)
					break;

				if (nums[i] == nums[nums[i] - 1])
					break;

				int temp = nums[i];
				nums[i] = nums[temp - 1];
				nums[temp - 1] = temp;
			}
		}
 
    	for (int i = 0; i < n; i++){
    		if (nums[i] != i + 1){
    			return i + 1;
    		}
    	}	
 
    	return n + 1;
    }

}
