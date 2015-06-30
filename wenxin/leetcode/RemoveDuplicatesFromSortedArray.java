package wenxin.leetcode;

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