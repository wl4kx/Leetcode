package wenxin.leetcode.java;

/*
 * problem 26.
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesFromSortedArray{
	
	public static void main(String[] args){
		int[] nums = {1, 1, 2};
		removeDuplicates(nums);
		//System.out.println(removeDuplicates(nums));
	}
	
    public static int removeDuplicates(int[] nums) {
    	if(nums.length==0)
    		return 0;
    	int previousInt = nums[0];
    	int count = 1;
    	for(int i=1;i<nums.length;i++){
        	if(nums[i]!=previousInt){
        		nums[count] = nums[i];
        		count++;
        		previousInt = nums[i];
        	}
        }
    	return count;
    }
}