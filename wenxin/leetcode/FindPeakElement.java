package wenxin.leetcode;

/*
 * A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Note:
Your solution should be in logarithmic complexity.
 */
public class FindPeakElement {

	/*
	 * key: binary search
	 * 这题要求我们在一个无序的数组里面找到一个peak元素，所谓peak，就是值比两边邻居大就行了。

对于这题，最简单地解法就是遍历数组，只要找到第一个元素，大于两边就可以了，复杂度为O(N)。但这题还可以通过二分来做。

首先我们找到中间节点mid，如果大于两边返回当前index就可以了，如果左边的节点比mid大，那么我们可以继续在左半区间查找，这里面一定存在一个peak，为什么这么说呢？假设此时的区间范围为[0, mid - 1]， 因为num[mid - 1]一定大于num[mid]了，如果num[mid - 2] <= num[mid - 1]，那么num[mid - 1]就是一个peak。如果num[mid - 2] > num[mid - 1]，那么我们就继续在[0, mid - 2]区间查找，因为num[-1]为负无穷，所以最终我们绝对能在左半区间找到一个peak。同理右半区间一样。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findPeakElement(int[] nums) {
		if (nums == null)
			return -1;
		if (nums.length == 1)
			return 0;
		int l = 0, r = nums.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (mid == 0) {
				if (nums[mid] > nums[mid + 1])
					return mid;
				else
					l = mid + 1;
			} else if (mid == nums.length - 1) {
				if (nums[mid] > nums[mid - 1])
					return mid;
				else
					r = mid - 1;
			} else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
				return mid;
			} else if (nums[mid] <= nums[mid - 1]) {
				r = mid - 1;
			} else { // nums[mid]<=nums[mid+1]
				l = mid + 1;
			}
		}
		return -1;
	}
}
