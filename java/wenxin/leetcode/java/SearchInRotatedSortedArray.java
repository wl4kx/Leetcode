package wenxin.leetcode.java;

/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 */

public class SearchInRotatedSortedArray {
	
	public static void main(String[] args){
		int[] nums = {1};
		int target = 0;
		System.out.println(search(nums, target));
	}
	
	public static int search(int[] nums, int target) {
		return binarySearch(0, nums.length - 1, nums, target);
	}

	public static int binarySearch(int start, int end, int[] nums, int target) {
		
		if(start==end){
			if(nums[start]==target)
				return start;
			else
				return -1;
		}
		
		int length = end - start +1;

		if(length ==2){
			if(nums[start]==target)
				return start;
			if(nums[end]==target)
				return end;
			return -1;
		}

		int middleIndex = (start + end) / 2;
		int middleInt = nums[middleIndex];
		if(middleInt== target){
			return middleIndex;
		}
		if(nums[start]<middleInt){
			if(target>=nums[start] && target<middleInt){
				return binarySearch(start, middleIndex, nums, target);
			}else{
				return binarySearch(middleIndex, end, nums, target);
			}
		}else{
			//(start>middleInt)
			if(target>middleInt && target<=nums[end]){
				return binarySearch(middleIndex, end, nums, target);
			}else{
				return binarySearch(start, middleIndex, nums, target);
			}
		}

	}
}