package wenxin.leetcode.java;

import java.util.ArrayList;
import java.util.List;

/*
 * problem 46.
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Permutations {
	public static void main(String[] args){
		Permutations instance = new Permutations();
		List<List<Integer>> r = instance.permute(new int[] {1,2,3});
		System.out.print(r);
	}
    public List<List<Integer>> permute(int[] num) {
    	
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
        			int thisNum = nums.remove(0);
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
