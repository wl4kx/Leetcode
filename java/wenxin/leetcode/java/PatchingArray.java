package wenxin.leetcode.java;

/*
 * Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.

Example 1:
nums = [1, 3], n = 6
Return 1.

Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
So we only need 1 patch.

Example 2:
nums = [1, 5, 10], n = 20
Return 2.
The two patches can be [2, 4].

Example 3:
nums = [1, 2, 2], n = 5
Return 0.
 */
public class PatchingArray {

	public static void main(String args[]) {
		PatchingArray instance = new PatchingArray();
		int[] nums = { 1, 2, 31, 33 };
		int n = 2147483647;
		System.out.println(instance.minPatches(nums, n));
	}

	/*
	 * basic idea is
	 * if array {a, b, c} can form all numbers up to n, then {a, b, c, d} can form all numbers up to n+d given that d is smaller than 2 times (a, b, c, d).
	 * for example, [1, 2, 4] can form all numbers up to 1+2+4=7, then [1, 2, 4, 9] can reach up to 7+9=16.
	 */
	public int minPatches(int[] nums, int n) {

		int patchCount = 0;
		// use double because of possible integer overflow.
		double reach = 0;
		int arrayCount = 0;

		int nextNum = -1;
		if (nums.length != 0) {
			nextNum = nums[arrayCount];
			arrayCount++;
		}
		while (reach < n) {
			if (nextNum == reach + 1) {
				reach = reach + nextNum;
				if (arrayCount >= nums.length) {
					// no array element now.
					nextNum = -1;
				} else {
					nextNum = nums[arrayCount];
					arrayCount++;
				}

			} else if (nextNum == -1 || nextNum > reach) {
				reach = reach + reach + 1;
				patchCount++;
			} else if (nextNum <= reach) {
				reach = reach + nextNum;
				if (arrayCount >= nums.length) {
					// no array element now.
					nextNum = -1;
				} else {
					nextNum = nums[arrayCount];
					arrayCount++;
				}
			}
		}

		return patchCount;
	}

}