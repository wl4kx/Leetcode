package wenxin.leetcode;

import java.util.LinkedList;
import java.util.Set;

/*
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
 */
public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {

    	dict.remove(start);
    	int strlen = start.length();
    	LinkedList<String> queue = new LinkedList<String>();
    	LinkedList<Integer> depthQ = new LinkedList<Integer>();
    	queue.push(start);
    	depthQ.push(1);
    	while(!queue.isEmpty()){
    		String str = queue.removeLast();
    		Integer currDistance = depthQ.removeLast();
    		char[] ca = str.toCharArray();
    		for(int i =0;i<strlen;i++){
    			for(int j='a';j<='z';j++){
    				if(ca[i]!=j){
    	    			char[] catemp = ca.clone();
		    			catemp[i] = (char) j;
		    			String newStr = new String(catemp);
		    			if(newStr.equals(end)){
		    				return currDistance+1;
		    			}
		    			if(dict.contains(newStr)){
		    				queue.push(newStr);
		    				depthQ.push(currDistance+1);
		    				dict.remove(newStr);
		    			}
		    			
    				}
    			}
    		}
    	}
    	
		return 0;
        
    
        
    }
}
