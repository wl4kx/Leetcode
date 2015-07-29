/**
 * 
 */
package wenxin.leetcode;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 42.
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TrappingRainWater {

	/**
	 * @param args
	 */
	/*
	 * Solution from http://blog.csdn.net/linhuanmars/article/details/20888505
	 * 基本思路是这样的，用两个指针从两端往中间扫，在当前窗口下，如果哪一侧的高度是小的，那么从这里开始继续扫，如果比它还小的，肯定装水的瓶颈就是它了，可以把装水量加入结果，如果遇到比它大的，立即停止，重新判断左右窗口的大小情况，重复上面的步骤。这里能作为停下来判断的窗口，说明肯定比前面的大了，所以目前肯定装不了水（不然前面会直接扫过去）。这样当左右窗口相遇时，就可以结束了，因为每个元素的装水量都已经记录过了。
	 */
	public static void main(String[] args) {
		TrappingRainWater instance = new TrappingRainWater();
		
	}
	
    public int trap(int[] height) {
    	int[] left = new int[height.length];
    	int[] right = new int[height.length];
    	
    	//scan from left to right to get max left for each element.
        for (int i = 1; i < height.length; i++) {
			if(height[i]>=height[i-1]){
				left[i] = left[i-1];
			}else{
				left[i] = Math.max(height[i-1], left[i-1]);
			}
		}
        
    	//scan from right to left to get max left for each element.
        for (int i = height.length -2; i >= 0; i--) {
			if(height[i]>=height[i+1]){
				right[i] = right[i+1];
			}else{
				right[i] = Math.max(height[i+1], right[i+1]);
			}
		}
        
        //scan again to find total water.
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
			int water = Math.min(left[i], right[i]) - height[i];
			if(water>0){
				sum += water;
			}
		}
        
        return sum;
    }
    
}
