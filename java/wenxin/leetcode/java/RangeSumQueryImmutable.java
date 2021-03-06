package wenxin.leetcode.java;

/*
 * Given an integer array nums, find the sum of the elements between indices i and j (i �? j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.

 */
public class RangeSumQueryImmutable {
	
	public static void main(String[] args){
		RangeSumQueryImmutable rsqi = new RangeSumQueryImmutable();
		int nums[] = {-2, 0, 3, -5, 2, -1};
		NumArray instance = rsqi.new NumArray(nums);
		System.out.println(instance.sumRange(0,2));
		System.out.println(instance.sumRange(2,5));
		System.out.println(instance.sumRange(0,5));
	}

    public class NumArray {
    	int[] sumArr;
        public NumArray(int[] nums) {
            sumArr = new int[nums.length+1];
            for (int i = 1; i < nums.length+1; i++) {
    			sumArr[i] = nums[i-1] + sumArr[i-1];
    		}
        }

        public int sumRange(int i, int j) {
            return sumArr[j+1] - sumArr[i];
        }
    }
}
