package wenxin.leetcode.java;

/*
 * problem 35.
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 â†? 2
[1,3,5,6], 2 â†? 1
[1,3,5,6], 7 â†? 4
[1,3,5,6], 0 â†? 0
 */
public class SearchInsertPosition {
/*
 * binary search.
 */
	public static void main(String[] args) {
		SearchInsertPosition instance = new SearchInsertPosition();
		int[] nums = {1,2,3,4,5,10};
		System.out.println(instance.searchInsert(nums, 2));

	}
    public int searchInsert(int[] nums, int target) {
        if(nums.length==0 || nums[0]>=target)
        	return 0;
        if(nums[nums.length-1]<target){
        	return nums.length;
        }
        
        int start = 0;
        int end = nums.length-1;
        
        int upperBound = nums.length-1;
       // int lowerBound = 0;
        
        while(start<=end){
        	
        	int middle = (start + end)/2;
        	if(nums[middle]>target){
        		upperBound = middle;
        		end = middle - 1;
        	}else if(nums[middle]<target){
        	//	lowerBound = middle;
        		start = middle + 1;
        	}else{
        		return middle;
        	}
        	
        }
        
        return upperBound;
    }
}
