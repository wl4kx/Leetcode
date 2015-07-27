package wenxin.leetcode;

/* problem 34.
 * Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */

public class SearchForARange {
	
	public static void main(String[] args){
		int[] arr = {8};
		int[] result = searchRange(arr, 7);
		System.out.println(result[0]+"-"+ result[1]);
	}
	
	public static int[] searchRange(int[] nums, int target) {
		
		if(nums.length == 0){
			int[] arr = {-1, -1};
			return arr;
		}

		int left = binarySearchLeft(nums, 0, nums.length - 1, target);

		int right = binarySearchRight(nums, 0, nums.length - 1, target);

		int result[] = { left, right };

		return result;

	}

	public static int binarySearchLeft(int[] nums, int start, int end, int target) {

		int length = end - start + 1;
		if (length == 1) {
			if (nums[start] == target)
				return start;
			else
				return -1;
		}
		if (length == 2) {
			if (nums[start] == nums[end] && nums[start] == target)
				return start;
			else if (nums[start] == target)
				return start;
			else if (nums[end] == target)
				return end;
			else
				return -1;
		}

		int middleIndex = (start + end) / 2;
		int middle = nums[middleIndex];
		if (middle < target) {
			return binarySearchLeft(nums, middleIndex + 1, end, target);
		} else {
			// middle => target
			return binarySearchLeft(nums, start, middleIndex, target);
		}
	}

	public static int binarySearchRight(int[] nums, int start, int end, int target) {

		int length = end - start + 1;
		if (length == 1) {
			if (nums[start] == target)
				return start;
			else
				return -1;
		}
		if (length == 2) {
			if (nums[start] == nums[end] && nums[start] == target)
				return end;
			else if (nums[start] == target)
				return start;
			else if (nums[end] == target)
				return end;
			else
				return -1;
		}

		int middleIndex = (start + end) / 2;
		int middle = nums[middleIndex];
		if (middle > target) {
			return binarySearchRight(nums, start, middleIndex - 1, target);
		} else {
			// middle <= target
			return binarySearchRight(nums, middleIndex, end, target);
		}
	}
}