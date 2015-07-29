/**
 * 
 */
package wenxin.leetcode;


/**
 * @author liao.wenxin
 *
 */
/*
 * problem 45.
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class JumpGameII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JumpGameII instance = new JumpGameII();
		int[] nums = {3,4,3,2,5,4,3};
		/*
		 *  test cases: 
		 *  3,4,3,2,5,4,3
		 *  1,2
		 */
		System.out.println(instance.jump(nums));

	}
	/*
	 * Scan from first element to last. For each step, see furthest element that step can reach. If this element pass last element, return current step number +1.
	 * For example, consider 3,4,3,2,5,4,3
	 * When step is 0, obviously doesn't qualify.
	 * Then, since step0's furthest reach is 0+nums[0]=3, so step1 include traveling elements up to index 3.
	 * Then, since step1's furthest reach is 1+nums[1]=5, so step2 include traveling elements up to index 5.
	 * Then, since step2's furthest reach is 5+nums[5]=9 which is more than length of nums. return current step number plus 1.
	 */
	public int jump(int[] nums) {

		if (nums.length == 0 || nums.length == 1) {
			return 0;
		}

		int step = 0;
		int end = 0;
		int index = 0;
		int maxReach = 0;
		
		while(index<nums.length){
			while (index <= end) {
				maxReach = Math.max(maxReach, index + nums[index]);
				if (maxReach >= nums.length - 1) {
					return step + 1;
				}
				index++;
			}
			end = maxReach;
			step++;
		}
		
		
		return -1;

	}

    /*
     * below is my initial method. Time limit exceeded.
     * 
        
    	if(nums.length==0 || nums.length ==1){
    		return 0;
    	}
    	
    	int[] dp = new int[nums.length];
    	for (int i = 0; i < dp.length; i++) {
    		int num = nums[i];
    		if(num + i >= nums.length){
    			dp[nums.length-1] = Math.min(dp[nums.length-1], dp[i] + 1);
    			break;
    		}
    		int count = 1;
    		while(count<=num){
    			if(i+count>=nums.length)
    				break;
    			if(dp[i+count] == 0){
    				//not yet visited.
    				dp[i+count] = dp[i] + 1;
    			}else{
    				dp[i+count] = Math.min(dp[i+count], dp[i] + 1);	
    			}
    			count++;
    		}

		}
    	
    	return dp[nums.length-1];
    	
    
     */
}
