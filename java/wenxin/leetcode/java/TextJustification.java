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
 * problem 68. solution from http://codesniper.blogspot.com/2015/03/68-text-justification-leetcode.html
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.
 */
public class TextJustification {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public List<String> fullJustify(String[] words, int L) {
	     List<String> res=new ArrayList<String>();  
	     if(words==null || words.length==0) return res;  
	     int start=0;  
	     int tL=0;  
	     for(int i=0;i<words.length;i++){  
	       if(i!=start) tL++;  
	       tL+=words[i].length();  
	       if(tL>L){  
	         tL=tL-words[i].length()-1;  
	         int slot=(i-1-start==0)? 1:i-1-start;  
	         int wNum=(i-1-start==0)? L-tL : (L-tL)/slot+1;  
	         int extraPosition=start-1+(L-tL)%slot;  
	         StringBuilder sb=new StringBuilder();  
	         for(int j=start;j<=i-1;j++){  
	           sb.append(words[j]);  
	           if(start==i-1 || j!=i-1) {  
	             for(int k=1;k<=wNum;k++) sb.append(" ");  
	           }  
	           if(j<=extraPosition) sb.append(" ");  
	         }  
	         res.add(sb.toString());  
	         start=i;  
	         tL=words[i].length();  
	       }  
	     }  
	     StringBuilder sb=new StringBuilder();  
	     for(int i=start;i<words.length;i++){  
	         if(i!=start) sb.append(" ");  
	         sb.append(words[i]);  
	       }  
	     for(int j=1;j<=L-tL;j++) sb.append(" ");  
	     res.add(sb.toString());  
	     return res;  
	   }  
}
