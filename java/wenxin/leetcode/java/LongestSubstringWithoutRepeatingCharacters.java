package wenxin.leetcode.java;

import java.util.HashMap;

/*
 * problem 3.
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("aleiivuuxszpaqojv"));
	}

	public static int lengthOfLongestSubstring(String s) {
		int longest = 0;
		if (s.length() == 0) {
			return longest;
		}

		char[] c = s.toCharArray();
		int p1 = 0;
		int p2 = 0;

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		int length = 0;
		while (p1 < s.length()) {

			if (map.containsKey(c[p1])) {
				int duplicatePosition = map.get(c[p1]);
				int elementsToRemove = duplicatePosition - p2 + 1;

				for (int i = p2; i < p2 + elementsToRemove; i++) {
					map.remove(c[i]);
				}
				p2 = duplicatePosition + 1;
				length = p1 - p2 + 1;
			} else {
				length++;
				longest = Math.max(length, longest);
			}
			map.put(c[p1], p1);
			p1++;

		}

		return longest;
	}
}
