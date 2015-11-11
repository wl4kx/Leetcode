package wenxin.leetcode;

/*
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
public class MoveZeroes {
	public static void main(String[] args){
		MoveZeroes instance = new MoveZeroes();
		int[] nums = {0, 5, 0};
		instance.moveZeroes(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
/*	my slow solution
	public void moveZeroes(int[] nums) {
		if (nums.length < 2)
			return;
		int last = nums.length - 1;
		int first = nums.length - 1;
		while (first >=0) {
			if (nums[first] == 0) {

				int temp = first;
				while (temp != last) {
					nums[temp] = nums[temp + 1];
					temp++;
				}
				nums[last] = 0;
				last--;

			}
			first--;
		}

	}*/
	public void moveZeroes(int[] nums) {
	    int i = -1, j = 0;
	    while (j < nums.length) {
	        if (nums[j] != 0) {
	            swap(++i, j, nums);
	        }
	        j++;
	    }
	}

	public void swap(int i, int j, int[] nums) {
	    int temp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = temp;
	}
}
