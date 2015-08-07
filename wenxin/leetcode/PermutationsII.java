/**
 * 
 */
package wenxin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 47.
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
 */
public class PermutationsII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PermutationsII instance = new PermutationsII();
		List<List<Integer>> r = instance.permuteUnique(new int[] {1,1,2});
		System.out.print(r);

	}
	/*
	 * similar to problem 46 Permutaions.
	 * Added code to avoid using same elements for searching.
	 * For example, consider (1, 1, 2)
	 * first it's going to be a list like {1, 2}, NOTICE it's only using one 1. Because same value will be skipped.
	 * second it's going to be a list like {11, 12, 21}
	 * thrid it's going to be a list like {112, 121, 211}
	 */
    public List<List<Integer>> permuteUnique(int[] num) {
    	//**********added code***************
    	Arrays.sort(num);
    	//*********************************************
    	int size= num.length ;
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<List<Integer>> numLeft = new ArrayList<List<Integer>>();
    	ArrayList<Integer> first = new ArrayList<Integer>();
    	ArrayList<Integer> availableNums = new ArrayList<Integer>();
    	for(int i = 0 ;i<num.length;i++){
    		availableNums.add(num[i]);
    	}
    	
    	result.add(first);
    	numLeft.add(availableNums);
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	while(!result.isEmpty()){
    		List<Integer> curList = result.remove(0);
    		List<Integer> nums = numLeft.remove(0);
    		if(curList.size()==size){
    			ret.add(curList);
    		}else{
    			int index = 0;
    			ArrayList<Integer> copyNums = new ArrayList<Integer>(nums);

        		while(!nums.isEmpty()){
        			
        			//**********added code***************
        			int thisNum = nums.remove(0);
        			if(index>0 && copyNums.get(index-1).equals(copyNums.get(index))){
        				index++;
        				continue;
        			}
        			//*********************************************
        				
        			ArrayList<Integer> toAdd = new ArrayList<Integer>(curList);
        			ArrayList<Integer> tempNums = new ArrayList<Integer>(copyNums);
        			tempNums.remove(index);
        			index++;
        			toAdd.add(thisNum);
        			result.add(toAdd);
        			numLeft.add(tempNums);
        		}
    		}
    	}
    	
    	
		return ret;
        
    }

}
