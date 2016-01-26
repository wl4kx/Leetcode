package wenxin.leetcode.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given a string s and a dictionary of words dict, 
 * add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
 */
public class WordBreakII {

	public static void main(String[] args) {
		WordBreakII instance = new WordBreakII();
		HashSet<String> wordDict = new HashSet<String>();
	/*
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		String s = "catsanddog";
		*/
		
		wordDict.add("aaaa");
		wordDict.add("aaa");
		String s = "aaaaaaa";
		
		List<String> result = instance.wordBreak(s, wordDict);
		System.out.println(result);

	}
	
 /*   
  * This method still won't pass because of TLE
  * 
  * public List<String> wordBreak(String s, Set<String> wordDict) {


    	List<List<String>> result = new ArrayList<List<String>>(s.length()+1);
    	
    	result.add(new ArrayList<String>(0));
    	if(!wordBreakI(s, wordDict)){
    		return result.get(0);
    	}

		int[] dp = new int[s.length() + 1];
		dp[0] = 0;

		for (int i = 1; i <= s.length(); i++) {
			result.add(new ArrayList<String>());
			if (wordDict.contains(s.substring(0, i))) {
				
				result.get(i).add(s.substring(0, i));
				dp[i] = i;
			} else {
				int last = dp[i - 1];
				boolean found = false;
				while (last != 0) {
					String subStr = s.substring(last, i);
					if (wordDict.contains(subStr)) {
						List<String> lastList = result.get(last);
						for(String st : lastList){
							String newSt = st+" "+subStr;
							result.get(i).add(newSt);
						}
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

		return result.get(s.length());

	
    }*/
    
	public boolean wordBreakI(String s, Set<String> wordDict) {

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
    
/*	
 * Time limit exceeded without first check if it's possible s made up with words in dictionary. Uses WordBreakI method to do this check.
 */
    public List<String> wordBreak(String s, Set<String> wordDict) {
    	
    	List<String> result = new ArrayList<String>();
    	if(!wordBreakI(s, wordDict)){
    		return result;
    	}
    	if(s==null || s.length()==0){
    		return result;
    	}
    	for (int i = 1; i <= s.length(); i++) {
    		String subStr = s.substring(0,i);
			if(wordDict.contains(subStr)){
				
				String str = subStr;
				List<String> list = wordBreak(s.substring(i, s.length()), wordDict);
				if(list.isEmpty() && i!=s.length()){
					continue;
				}else if(list.isEmpty() && i==s.length()){
					result.add(str);
				}
				for(String ss: list){
					result.add(str+" "+ss);
				}
			}
		}

    	return result;
    	
	}
    
    

}
