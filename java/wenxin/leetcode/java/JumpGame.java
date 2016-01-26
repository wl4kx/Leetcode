/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 */
public class JumpGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JumpGame instance = new JumpGame();
		int[] nums = {1};
		System.out.println(instance.canJump(nums));

	}

    public boolean canJump(int[] nums) {
    	if(nums.length==0){
    		return true;
    	}
        int maxReach = 0;
        
        int i=0;
        while(i<=maxReach){
        	maxReach = Math.max(maxReach, i+nums[i]);
        	if(maxReach>=nums.length-1){
        		return true;
        	}
        	i++;
        }
        return false;
    }
    
}
