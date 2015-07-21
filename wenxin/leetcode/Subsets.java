package wenxin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] S) {
Arrays.sort(S);
    	int length = S.length;
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	result.add(new ArrayList<Integer>());
    	for(int i=1;i<=length;i++){
    		result.addAll(combine(S, i));
    	}
    	
    	
    	
    	
		return result;
        
    }
    
    public static ArrayList<ArrayList<Integer>> combine(int[] S, int k) {
    	int currentPos = 0;
    	ArrayList<Integer> currentNum = new ArrayList<Integer>();
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	buildNum(S, k , currentPos, currentNum, result );
    	
    	
		return result;

    }
    
    public static void buildNum(int[] allNums, Integer length, Integer currentPos, ArrayList<Integer> currentNum, ArrayList<ArrayList<Integer>> result){
    	int allNumSize = allNums.length;
    	if (currentNum.size()==length){
    		result.add(currentNum);
    	}else{
    		
        	for(int i = currentPos;i<allNumSize;i++){
        		ArrayList<Integer> temp = new ArrayList<Integer>(currentNum);
        		temp.add(allNums[i]);
        		buildNum(allNums, length, i+1, temp, result);
        	}
    	}

    	
    }
    
    public static void main(String[] args){
    	int[] S = {4,1,0};
    	System.out.println(subsets(S));
    }
}
