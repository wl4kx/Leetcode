package wenxin.leetcode.java;

import java.util.HashMap;
/*
 * problem 3.
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeatingCharacters_ {
	
	public static void main(String[] args) throws Exception {
		LongestSubstringWithoutRepeatingCharacters_ instance = new LongestSubstringWithoutRepeatingCharacters_();
		Assert.equals(instance.lengthOfLongestSubstring("abcabcbb"), 3);
		Assert.equals(instance.lengthOfLongestSubstring("abba"), 2);
		Assert.equals(instance.lengthOfLongestSubstring("aleiivuuxszpaqojv"), 10);
	}

	/*
	 * A faster way is to use int[] instead of HashMap.
	 */
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		int maxLength = 0;
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				int pos = map.get(c);
				if (pos >= start) {
					start = pos + 1;
				}
				maxLength = Math.max(i - start + 1, maxLength);
				map.put(c, i);
			} else {
				map.put(c, i);
				maxLength = Math.max(i - start + 1, maxLength);
			}
		}
		return maxLength;
	}
}
