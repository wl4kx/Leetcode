package wenxin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/*
 * problem 49.
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
 */
/*
 * How to solve:
 * Anagram strings will be same after sort their characters.
 */
public class Anagrams {
    public List<String> anagrams(String[] strs) {

    	ArrayList<String> ret = new ArrayList<String>();
    	HashMap<String, List<Integer>> result = new HashMap<String, List<Integer>>();
        for(int i =0;i<strs.length;i++){
        	String s = strs[i];
        	char[] ca = s.toCharArray();
        	Arrays.sort(ca);
        	String sortedStr = new String(ca);


        	if(result.containsKey(sortedStr)){
        		result.get(sortedStr).add(i);
        	}else{
        		ArrayList<Integer> list = new ArrayList<Integer>();
        		list.add(i);
        		result.put(sortedStr, list);
        	}
        	
        }
        
        Set<String> keys = result.keySet();
        for(String key:keys){
        	if(result.get(key).size()>1){
        		List<Integer> list = result.get(key);
        		for(Integer i:list){
        			ret.add(strs[i]);
        		}
        	}
        }
        return ret;
    
    }
}
