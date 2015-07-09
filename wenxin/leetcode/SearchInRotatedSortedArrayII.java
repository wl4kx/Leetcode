/**
 * 
 */
package wenxin.leetcode;

/**
 * @author liao.wenxin
 *
 */
public class SearchInRotatedSortedArrayII {

	/**
	 * @param args
	 */
	/*
	 * problem 81.
	 * Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
	 */
	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 3};
		int target = 3;
		
		System.out.println(search(nums, target));

	}
	
    public static boolean search(int[] nums, int target) {
        
    	int start = 0;
    	int end = nums.length - 1;
    	
    	if(start == end){
    		if(nums[start] == target){
    			return true;
    		}else{
    			return false;
    		}    			
    	}
    	
    	while(start<=end){
    		
    		int middleIndex = (start + end)/2;
    		int middle = nums[middleIndex];
    		
    		if(middle == target){
    			return true;
    		}
    		
    		int first = nums[start];
    		if(middle>first){
    			//first half is in order
    			if(middle>target){
    				if(nums[start]<=target){
    					end = middleIndex - 1;
    				}else{
    					start = middleIndex + 1;	
    				}
    			}else{
    				start = middleIndex + 1;
    			}
    		}else if(middle<first){
    			//second half is in order
    			if(middle>target){
    				end = middleIndex - 1;
    			}else{
    				if(nums[end]>=target){
    					start = middleIndex + 1;
    				}
    				else{
    					end = middleIndex - 1;
    				}
    					
    			}
			} else/* middle == first */{

				/*
				 * no way to determine target is in which half.
				 * have to use linear search.
				 */
				start++;

			}
    		
    	}
    	
    	return false;
    	
    }

}
