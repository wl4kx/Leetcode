/**
 * 
 */
package wenxin.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liao.wenxin
 *
 */
public class LongestConsecutiveSequence {

	/**
	 * @param args
	 */
	/*
	 * problem 128. Given an unsorted array of integers, find the length of the
	 * longest consecutive elements sequence.
	 * 
	 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive
	 * elements sequence is [1, 2, 3, 4]. Return its length: 4.
	 * 
	 * Your algorithm should run in O(n) complexity.
	 */
	public static void main(String[] args) {
		int[] nums = { -3, 2, 8, 5, 1, 7, -8, 2, -8, -4, -1, 6, -6, 9, 6, 0, -7, 4, 5, -4, 8, 2, 0, -2, -6, 9, -4, -1 };
		System.out.println(longestConsecutive(nums));

	}

	/*
	 * Sort won't work because of O(n). Use map to solve this.
	 * Now lookup time is O(1).
	 */
	public static int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();

		for (int i : nums) {
			set.add(i);
		}
		int max = 0;

		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				int next = nums[i] - 1; // 找比num[i]小一个的值
				int count = 1;
				set.remove(nums[i]); // 及时的移除，减少之后的查找时间
				//This while loop doesn't cause runtime to be O(n^2) because visited numbers are removed.
				//So solution is still O(n).
				while (set.contains(next)) {
					set.remove(next);
					next--;
					count++;
				}
				next = nums[i] + 1; // 找比num[i]大一个的值
				while (set.contains(next)) {
					set.remove(next);
					next++;
					count++;
				}
				max = Math.max(max, count);
			}
		}

		return max;
	}
}
