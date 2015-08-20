package wenxin.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {

	public static void main(String[] args) {
		WordBreak instance = new WordBreak();
		HashSet<String> wordDict = new HashSet<String>();
		wordDict.add("a");
		wordDict.add("abc");
		wordDict.add("b");
		wordDict.add("cd");
		String s = "abcd";
		System.out.println(instance.wordBreak(s, wordDict));

	}
/*
 * analysis, dp[i]=j represents for substring of s from 0 to i, j is the largest index in s such that
 * substring from 0 to j is a wordBreak.
 * 
 * For example, if wordDict has {"liao","wenxin","liaowe"} and s is "liaowenxin"
 * dp will look like this:      [0,0,0,0,4,4,6,6,6,6,10]
 */
	public boolean wordBreak(String s, Set<String> wordDict) {

		int[] dp = new int[s.length() + 1];
		dp[0] = 0;

		for (int i = 1; i <= s.length(); i++) {

			if (wordDict.contains(s.substring(0, i))) {
				dp[i] = i;
			} else {
				int last = dp[i - 1];
				boolean found = false;
				while (last != 0) {
					if (wordDict.contains(s.substring(last, i))) {
						dp[i] = i;
						found = true;
					}
					last = dp[last - 1];
				}
				if (!found) {
					dp[i] = dp[i - 1];
				}

			}

		}

		return dp[s.length()] == s.length();

	}
}
