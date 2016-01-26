/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 75.
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
 */
public class SortColors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortColors instance = new SortColors();
		int[] nums = {2, 0, 1, 2, 1, 0};
		instance.sortColors(nums);
		
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+"->");	
		}
		

	}

	public void sortColors(int[] nums) {

		int redP = 0; // red pointer.
		int blueP = nums.length - 1; // blue pointer.

		for (int i = 0; i <= blueP;) {

			if (nums[i] == 0) {
				swap(nums, i, redP);
				redP++;
			}
			
			if (nums[i] == 2) {
				swap(nums, i, blueP);
				blueP--;
				continue;
			}
			
			i++;

		}

	}
	
	public void swap(int[] nums, int ia, int ib){
		
		int temp = nums[ia];
		nums[ia] = nums[ib];
		nums[ib] = temp;
		
	}
    
}
