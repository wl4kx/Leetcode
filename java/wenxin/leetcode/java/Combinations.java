package wenxin.leetcode.java;

import java.util.ArrayList;

/*
 * problem 77.
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
public class Combinations { 
    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
    	int index = 0;
    	ArrayList<Integer> currentNum = new ArrayList<Integer>();
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	buildNum(n, k , index,currentNum, result );
    	
    	
		return result;

    }
    
    public static void buildNum(int n, int k, int index, ArrayList<Integer> currentNum, ArrayList<ArrayList<Integer>> result){
    	
    	if (currentNum.size()==k){
    		result.add(currentNum);
    	}else if(currentNum.size()+(n-index)>= k){
        	for(int i = index+1;i<=n;i++){
        		ArrayList<Integer> temp = new ArrayList<Integer>(currentNum);
        		temp.add(i);
        		buildNum(n, k, i, temp, result);
        	}
    	}

    	
    }
    
    public static void main(String[] args){
    	
    	int n = 4;
    	int k = 2;
    	ArrayList<ArrayList<Integer>> result = combine(n, k);
    	System.out.println(result);
    	
    	
    }

}
