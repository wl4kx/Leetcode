package wenxin.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class RegularExpressionMatching {
	
	public static HashMap<String, Set<String>> successMap = new HashMap<String, Set<String>>();
	public static HashMap<String, Set<String>> failMap = new HashMap<String, Set<String>>();

	public static void main(String[] args) {
		System.out.println(isMatch("", "c*c*"));
	}

	public static boolean isMatch(String s, String p) {
		boolean foundAnswer = false;
		// handle special cases.
		if (p.length() == 0 && s.length() != 0)
			return false;

		if (p.length() != 0 && s.length() == 0){
			if(p.length()>1 && p.charAt(1)=='*'){
				return isMatch(s, p.substring(2));
			}else{
				return false;	
			}
			
		}
			

		if (s.length() == 0 && p.length() == 0) {
			return true;
		}

		if (p.length() == 2) {
			if (p.charAt(1) == '*') {
				if (onlyContains(s, p.charAt(0)))
					return true;
				else
					return false;
			}
		}

		if (p.length() == 1) {
			if ((p.charAt(0) == '.' && s.length() == 1) || (p.charAt(0) == s.charAt(0) && s.length() == 1)) {
				return true;
			} else
				return false;
		}
		
		if(successMap.containsKey(p) && successMap.get(p).contains(s)){
			return true;
		}else if(failMap.containsKey(p) && failMap.get(p).contains(s)){
			return false;
		}
		
		// ====================================================================================
		char sc = s.charAt(0);
		char pc = p.charAt(0);
		char pc2 = p.charAt(1);

		if (pc2 != '*') {
			if (pc != sc && pc != '.') {
				return false;
			} else {
				return isMatch(s.substring(1), p.substring(1));
			}

		} else if (pc2 == '*') {
			boolean firstPart = false;
			boolean secondPart = false;
			boolean endOfString = false;
			int count = 0;
			while (!endOfString && !foundAnswer && count <= s.length()) {
				String firstStr = s.substring(0, count);
				String secondStr = s.substring(count);
				firstPart = isMatch(firstStr, "" + pc + pc2);
				secondPart = isMatch(secondStr, p.substring(2));
				if (firstPart && secondPart){
					foundAnswer = true;
				}else{
					
				}
					
				count++;
			}
		}

		
		if(foundAnswer){
			if(successMap.containsKey(p)){
				successMap.get(p).add(s);
			}else{
				Set<String> al = new HashSet<String>();
				al.add(s);
				successMap.put(p, al);
			}
		}else{
			if(failMap.containsKey(p)){
				failMap.get(p).add(s);
			}else{
				Set<String> al = new HashSet<String>();
				al.add(s);
				failMap.put(p, al);
			}
		}
		return foundAnswer;
	}

	private static boolean onlyContains(String str, char ch) {
		if (ch == '.')
			return true;
		boolean result = true;
		for (char c : str.toCharArray()) {
			if (c != ch) {
				result = false;
				break;
			}
		}
		return result;
	}
}