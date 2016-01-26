/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 58.
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
 */
public class LengthOfLastWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LengthOfLastWord instance = new LengthOfLastWord();
		System.out.println(instance.lengthOfLastWord("aa"));

	}

	/*
	 * solution from https://leetcode.com/problems/longest-substring-without-repeating-characters/
	 */
	public int lengthOfLastWord(String s) { 
	    if(s==null || s.length() == 0)
	        return 0;
	 
	    int result = 0;
	    int len = s.length();
	 
	    boolean flag = false;
	    for(int i=len-1; i>=0; i--){
	        char c = s.charAt(i);
	        if((c>='a' && c<='z') || (c>='A' && c<='Z')){
	            flag = true;
	            result++;
	        }else{
	            if(flag)
	                return result;
	        }
	    }
	 
	    return result;
	}
	
}
