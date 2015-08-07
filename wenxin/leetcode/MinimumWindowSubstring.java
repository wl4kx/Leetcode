/**
 * 
 */
package wenxin.leetcode;

import java.util.HashMap;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 76. Solution from http://www.lifeincode.net/programming/leetcode-minimum-window-substring-java/
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * keep two pointers. Start and end. move two pointer and find minimum length.
	 */
	 public String minWindow(String S, String T) {
	        HashMap<Character, Integer> dict = new HashMap<>();
	        for (int i = 0; i < T.length(); i++) {
	            char c = T.charAt(i);
	            if (!dict.containsKey(c))
	                dict.put(c, 1);
	            else
	                dict.put(c, dict.get(c) + 1);
	        }
	        HashMap<Character, Integer> found = new HashMap<>();
	        int foundCounter = 0;
	        int start = 0;
	        int end = 0;
	        int min = Integer.MAX_VALUE;
	        String minWindow = "";
	        while (end < S.length()) {
	            char c = S.charAt(end);
	            if (dict.containsKey(c)) {
	                if (found.containsKey(c)) {
	                    if (found.get(c) < dict.get(c))
	                        foundCounter++;
	                    found.put(c, found.get(c) + 1);
	                } else {
	                    found.put(c, 1);
	                    foundCounter++;
	                }
	            }
	            if (foundCounter == T.length()) {
	                //When foundCounter equals to T.length(), in other words, found all characters.
	                char sc = S.charAt(start);
	                while (!found.containsKey(sc) || found.get(sc) > dict.get(sc)) {
	                    if (found.containsKey(sc) && found.get(sc) > dict.get(sc))
	                        found.put(sc, found.get(sc) - 1);
	                    start++;
	                    sc = S.charAt(start);
	                }
	                if (end - start + 1 < min) {
	                    minWindow = S.substring(start, end + 1);
	                    min = end - start + 1;
	                }
	            }
	            end++;
	        }
	        return minWindow;
	    }
}
