/**
 * 
 */
package wenxin.leetcode;


/**
 * @author liao.wenxin
 *
 */
public class WildcardMatching {
	/*
	 * '?' Matches any single character. '*' Matches any sequence of characters
	 * (including the empty sequence).
	 * 
	 * The matching should cover the entire input string (not partial).
	 * 
	 * The function prototype should be: bool isMatch(const char *s, const char
	 * *p)
	 * 
	 * Some examples: isMatch("aa","a") → false isMatch("aa","aa") → true
	 * isMatch("aaa","aa") → false isMatch("aa", "*") → true isMatch("aa", "a*")
	 * → true isMatch("ab", "?*") → true isMatch("aab", "c*a*b") → false
	 */
	public static void main(String[] args) {
		String s = "a";
		String p = "?";
		System.out.println(isMatch("aabbcc", "*b*c"));
		//System.out.println(trimPattern("****a"));
	}
	public static boolean isMatch(String s, String p){
		int i = 0;
		int j = 0;
		int starIndex = -1;
		int iIndex = -1;
	 
		while (i < s.length()) {
			if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
				++i;
				++j;
			} else if (j < p.length() && p.charAt(j) == '*') {
				starIndex = j;		
				iIndex = i;
				j++;
			} else if (starIndex != -1) {
				j = starIndex + 1;
				i = iIndex+1;
				iIndex++;
			} else {
				return false;
			}
		}
	 
		while (j < p.length() && p.charAt(j) == '*') {
			++j;
		}
	 
		return j == p.length();
	}


	/*static HashMap<String, HashSet<String>> successMap = new HashMap<String, HashSet<String>>();
	static HashMap<String, HashSet<String>> failMap = new HashMap<String, HashSet<String>>();

	public static boolean isMatch(String s, String p) {

		if (successMap.containsKey(p) && successMap.get(p).contains(s)) {
			return true;
		}
		if (failMap.containsKey(p) && failMap.get(p).contains(s)) {
			return false;
		}

		while (p.length() > 0 && s.length() > 0) {
			char p1 = p.charAt(0);
			char s1 = s.charAt(0);
			if (p1 == '*') {
				p = trimPattern(p);
				for (int i = 0; i <= s.length(); i++) {
					if (isMatch(s.substring(i), p.substring(1))) {
						return true;
					}
				}
				saveInFailMap(p, s);
				return false;
			} else if (p1 == '?') {
				s = s.substring(1);
				p = p.substring(1);
			} else {
				if (p1 == s1) {
					s = s.substring(1);
					p = p.substring(1);
				} else {
					saveInFailMap(p, s);
					return false;
				}
			}
		}

		if (s.length() == 0 && p.length() == 0) {
			saveInSuccessMap(p, s);
			return true;
		} else if (s.length() == 0) {
			for (int i = 0; i < p.length(); i++) {
				if (p.charAt(i) != '*'){
					saveInFailMap(p, s);
					return false;
				}
			}
			saveInSuccessMap(p, s);
			return true;
		} else {
			// p.length() ==0 && s.length()!=0
			saveInFailMap(p, s);
			return false;
		}
	}

	public static void saveInSuccessMap(String p, String s) {
		if (!successMap.containsKey(p)) {
			HashSet<String> set = new HashSet<String>();
			successMap.put(p, set);
		}
		successMap.get(p).add(s);
	}

	public static void saveInFailMap(String p, String s) {
		if (!failMap.containsKey(p)) {
			HashSet<String> set = new HashSet<String>();
			failMap.put(p, set);
		}
		failMap.get(p).add(s);
	}
	
	public static String trimPattern(String p){
		while(p.length()>1){
			if(p.charAt(1)=='*'){
				p = p.substring(1);
			}
			else
				break;
		}
		return p;
	}*/
}
