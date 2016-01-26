/**
 * 
 */
package wenxin.leetcode.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liao.wenxin
 *
 */
/*
 * Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class SummaryRanges {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SummaryRanges instance = new SummaryRanges();
		int[] nums = {0,1,2,4,5,7};
		//int[] nums = {0, 1};
		System.out.println(instance.summaryRanges(nums));
	}
	
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if(nums.length==0){
        	return result;
        }
        int start = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
    		if(nums[i] != pre+1){
    			if(start==pre){
        			result.add(start+"");
    			}else{
        			result.add(start+"->"+pre);
    			}

    			start = nums[i];
    			
    		}
    		pre = nums[i];
    		
		}
        
        if(start == nums[nums.length-1]){
        	result.add(start+"");
        }else{
        	result.add(start+"->"+pre);
        }
        
        return result;
    }

}
