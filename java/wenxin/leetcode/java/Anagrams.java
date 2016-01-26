package wenxin.leetcode.java;

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
 * 
 * Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.
Update (2015-08-09):
The signature of the function had been updated to return list<list<string>> instead of list<string>, as suggested here. If you still see your function signature return a list<string>, please click the reload button  to reset your code definition.

 */
public class Anagrams {
	/*
	 * 
	 * How to solve: Anagram strings will be same after sort their characters.
	 */
	public List<String> anagrams(String[] strs) {

		ArrayList<String> ret = new ArrayList<String>();
		HashMap<String, List<Integer>> result = new HashMap<String, List<Integer>>();
		for (int i = 0; i < strs.length; i++) {
			String s = strs[i];
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String sortedStr = new String(ca);

			if (result.containsKey(sortedStr)) {
				result.get(sortedStr).add(i);
			} else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				result.put(sortedStr, list);
			}

		}

		Set<String> keys = result.keySet();
		for (String key : keys) {
			if (result.get(key).size() > 1) {
				List<Integer> list = result.get(key);
				for (Integer i : list) {
					ret.add(strs[i]);
				}
			}
		}
		return ret;

	}
}
