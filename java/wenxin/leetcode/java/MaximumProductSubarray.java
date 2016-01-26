package wenxin.leetcode.java;

/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaximumProductSubarray {

	public static void main(String[] args) {
		MaximumProductSubarray instance = new MaximumProductSubarray();
		int[] arr = {2,3,-2,4};
		System.out.println(instance.maxProduct(arr));
	}
	
	//key: use dp. Similar to max sum subarray. Here keep track of both max and min. Because two negative might be greater than max.
    public int maxProduct(int[] nums) {
    	if(nums.length==0){
    		return 0;
    	}
    	
        int maxLocal = nums[0];
        int minLocal = nums[0];
        
        int max = maxLocal;
        
        for (int i = 1; i < nums.length; i++) {
			int temp = maxLocal;
        	maxLocal = Math.max(minLocal * nums[i], Math.max(maxLocal*nums[i], nums[i]));
        	minLocal = Math.min(temp * nums[i], Math.min(minLocal * nums[i], nums[i]));
        	
        	max = Math.max(maxLocal, max);
        	
		}
        
        return max;
        
    }

}
