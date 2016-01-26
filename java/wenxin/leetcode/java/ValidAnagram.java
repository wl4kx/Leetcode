/**
 * 
 */
package wenxin.leetcode.java;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liao.wenxin
 *
 */
/*
 * Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.
 */
public class ValidAnagram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			int i = 0;
			if(map.containsKey(c)){
				i = map.get(c);
			}
			map.put(c, i + 1);
		}
		for (char c : t.toCharArray()) {
			if (map.containsKey(c)) {
				int count = map.get(c);
				if (count == 1)
					map.remove(c);
				else
					map.put(c, count - 1);
			}
		}
		return map.isEmpty();
	}

}
