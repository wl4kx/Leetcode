/**
 * 
 */
package wenxin.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liao.wenxin
 *
 */
/*
 * Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
 */
public class IsomorphicStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * compare each char in two strings. And store char to char mapping in a map. If later found this mapping is not same for any char, return false.
	 */
	public boolean isIsomorphic(String s, String t) {
	    if(s==null || t==null)
	        return false;
	 
	    if(s.length() != t.length())
	        return false;
	 
	    if(s.length()==0 && t.length()==0)
	        return true;
	 
	    HashMap<Character, Character> map = new HashMap<Character,Character>();
	    for(int i=0; i<s.length(); i++){
	        char c1 = s.charAt(i);
	        char c2 = t.charAt(i);
	 
	        Character c = getKey(map, c2);
	        if(c != null && c!=c1){
	            return false;
	        }else if(map.containsKey(c1)){
	            if(c2 != map.get(c1))
	                return false;
	        }else{
	            map.put(c1,c2);
	        }
	    }
	 
	    return true;
	}
	 
	// a method for getting key of a target value
	public Character getKey(HashMap<Character,Character> map, Character target){
	    for (Map.Entry<Character,Character> entry : map.entrySet()) {
	        if (entry.getValue().equals(target)) {
	            return entry.getKey();
	        }
	    }
	 
	    return null;
	}

}
