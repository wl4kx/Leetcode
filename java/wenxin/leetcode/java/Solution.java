package wenxin.leetcode.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class Solution {
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
 
	    public static int ladderLength(String start, String end, Set<String> dict) {
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
	  
	 // public void add(ListNode l1)
    
    public static void main(String[] args){

    	System.out.print(generateParenthesis(2));
    //	int[][] a = {{0}};
    	//setZeroes(a);
    }
    
    public static List<String> generateParenthesis(int n) {
    	
    	int length = n * 2;
    	
    	LinkedList<String> result = new LinkedList<String>();
    	LinkedList<Integer> diff = new LinkedList<Integer>();
    	ArrayList<String> ret = new ArrayList<String>();
    	result.add("");
    	diff.add(0);
    	
		while(!result.isEmpty()){
			String next = result.pop();
			int d = diff.pop();
			if(next.length()==length){
				ret.add(next);
			}else{
				if(d==0){
					result.push(next+"(");
					diff.push(d+1);
				}else{
					result.push(next+")");
					diff.push(d-1);
					if(next.length()+d<length){
						result.push(next+"(");
						diff.push(d+1);
					}
				}
			}
			
		}
    	return ret;
        
    }
    public ListNode swapPairs(ListNode head) {
    	ListNode n=head;    		
    	int temp =0;

    	while(head!=null && head.next!=null){
    		
    		temp = head.val;
    		head.val = head.next.val;
    		head.next.val= temp;
    		head = head.next.next;
    		
    	}
		return n;
        
    }
    public int removeElement(int[] A, int elem) {

 int[] result = new int[A.length];
 int length = A.length;
 int count = 0;

    	for(int i =0;i<A.length;i++){
    		
    		if(A[i]!=elem){
    			result[count] = A[i];
    			count++;
    		}    else{
    			length--;
    		}
    	}
for(int i =0;i<length;i++){
	A[i] = result[i];
}
		return length;
        
    }
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }

    
}