package wenxin.leetcode.java;

/*
 * problem 5.
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("aaaa"));

	}

	public static String longestPalindrome(String s) {
		// going from first char, check if both side of char match, store
		// longest longest palindromic substring. Take O(n^2).
		// O(n) algorithm (Manacher’s algorithm) can be found here:
		// http://articles.leetcode.com/2011/11/longest-palindromic-substring-part-ii.html
		if (s.length() == 0) {
			return "";
		}
		if (s.length() == 1) {
			return s;
		}
		if(s.length()==2){
			if (s.charAt(0) == s.charAt(1)) {
				return s;
			} else
			return "";
		}

		char[] c = s.toCharArray();
		int longest = 0;
		String result = "";

		for (int i = 0; i < c.length; i++) {
			
			int count = 1;
			while (i - count >= 0 && i + count < c.length && c[i - count] == c[i + count]) {
				if (2 * count + 1 > longest) {
					longest = 2 * count + 1;
					result = s.substring(i - count, i + count + 1);
				}
				count++;
			}

			count = 1;
			if (i + 1 < c.length && c[i] == c[i + 1]) {
				if (longest < 2) {
					longest = 2;
					result = s.substring(i, i + 2);
				}
				while (i - count >= 0 && i + 1 + count < c.length && c[i - count] == c[i + 1 + count]) {
					if (2 * count + 2 > longest) {
						longest = 2 * count + 2;
						result = s.substring(i - count, i + 2 + count);
					}
					count++;
				}
			}
			
		}

		return result;
	}
}
