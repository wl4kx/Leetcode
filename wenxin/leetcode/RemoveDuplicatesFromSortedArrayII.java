/**
 * 
 */
package wenxin.leetcode;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 80.
 * Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesFromSortedArrayII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArrayII instance = new RemoveDuplicatesFromSortedArrayII();
		int[] nums = {1,1,1,2,2,3};
		
		System.out.println(instance.removeDuplicates(nums));

	}
/*
 * similar to RemoveDuplicatesFromSortedArray.
 * Just added dupCount variable to keep at most 2 duplicates.
 */
    public int removeDuplicates(int[] nums) {
    	if(nums.length==0)
    		return 0;
    	int previousInt = nums[0];
    	int count = 1;
    	int dupCount = 1;
    	for(int i=1;i<nums.length;i++){
        	if(nums[i]!=previousInt){
        		nums[count] = nums[i];
        		count++;
        		previousInt = nums[i];
        		dupCount=1;
        	}else if(dupCount==1){
        		nums[count] = nums[i];
        		count++;
        		dupCount=2;
        	}
        }
    	return count;
    }
}
