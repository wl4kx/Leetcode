package wenxin.leetcode;

/*
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.
Example:
Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:
The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
 */
public class RangeSumQueryMutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RangeSumQueryMutable rsqm = new RangeSumQueryMutable();
		int nums[] = {1, 3, 5};
		NumArray instance = rsqm.new NumArray(nums);
		System.out.println(instance.sumRange(0, 2));
		instance.update(1, 2);
		System.out.println(instance.sumRange(0, 2));
	}

	public class NumArray {
		
		    private int[] tree;
		    private int[] nums;

		    public NumArray(int[] nums) {
		        this.nums = nums;
		        int sum = 0;
		        int lowbit;
		        tree = new int[nums.length + 1];
		        for (int i = 1; i < tree.length; i++) {
		            sum = 0;
		            lowbit = i & (-i);
		            for (int j = i; j > i - lowbit; j--) {
		                sum = sum + nums[j - 1];
		            }
		            tree[i] = sum;
		        }
		    }

		    void update(int i, int val) {
		        int diff = val - nums[i];
		        nums[i] = val;
		        i++;
		        for (; i < tree.length; i = i + (i & (-i))) {
		            tree[i] += diff;
		        }
		    }

		    public int sumRange(int i, int j) {
		        return getSum(j) - getSum(i - 1);
		    }

		    public int getSum(int i) {
		        int sum = 0;
		        i++;
		        while (i > 0) {
		            sum = sum + tree[i];
		            i = i - (i & (-i));
		        }
		        return sum;
		    }
		
		
		/*
		 * Data structure "Binary Indexed Tree" is designed to solve this kind of problem.
		 */
		
		
		
		
/*		
 * 	Below is too slow. Use BIT/Fenwick tree!
 * int[] sumArr;
		int[] nums;
		
		public NumArray(int[] nums) {
			this.nums = nums;
	        sumArr = new int[nums.length+1];
	        for (int i = 1; i < nums.length+1; i++) {
				sumArr[i] = nums[i-1] + sumArr[i-1];
			}
	    }
		
	    void update(int i, int val) {
	        if(nums[i]!=val){
	        	int difference = val - nums[i];
	        	nums[i] = val;
	        	for (int j = i+1; j < sumArr.length; j++) {
					sumArr[j] += difference;
				}
	        }
	    }

	    public int sumRange(int i, int j) {
	        return sumArr[j+1] - sumArr[i];
	    }*/
	}
}
