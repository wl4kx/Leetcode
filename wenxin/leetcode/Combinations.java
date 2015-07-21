package wenxin.leetcode;

import java.util.ArrayList;


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
