/**
 * 
 */
package wenxin.leetcode;

/**
 * @author liao.wenxin
 *
 */
/*
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?

Hint:

How about using a data structure such as deque (double-ended queue)?
The queue size need not be the same as the window’s size.
Remove redundant elements and the queue should store only elements that need to be considered.
 */
public class SlidingWindowMaximum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SlidingWindowMaximum instance = new SlidingWindowMaximum();
		int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
		int[] result = instance.maxSlidingWindow(nums, 3);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]+" ");
		}

	}

    public int[] maxSlidingWindow(int[] nums, int k) {
        
    	int maxIndex = 0;
    	int secondIndex = 0;
    	
    	int[] indices = new int[nums.length-k+1];
    	
    	for (int i = 0; i < k; i++) {
			if(nums[i]>nums[maxIndex]){
				maxIndex = i;
				indices[0] = i;
			}else if(nums[i]>nums[secondIndex]){
				secondIndex = nums[i];
			}
		}
    	
    	for (int i = k; i < nums.length; i++) {
    		if(i-k==maxIndex){
    			//maxIndex is out of window.
    			
    		}else{
    			if(nums[i]>nums[maxIndex]){
    				secondIndex = maxIndex;
    				maxIndex = i;
    			}else{
    				
    			}
    		}
		}
    	
    	return new int[1];
    }
    
}
