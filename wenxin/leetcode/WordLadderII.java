/**
 * 
 */
package wenxin.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author liao.wenxin
 *
 */
public class WordLadderII {

	/**
	 * @param args
	 */
	/*
	 * problem 126.
	 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
All words have the same length.
All words contain only lowercase alphabetic characters.
	 */
	public static void main(String[] args) {
		WordLadderII instance = new WordLadderII();
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		List<List<String>> result = instance.findLadders("hit", "cog", dict);

	}

	/*
	 * below method exceeds memory limit. See solution: https://leetcode.com/problems/word-ladder-ii/
	 */
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {

		List<List<String>> result = new LinkedList<List<String>>();
		
		List<List<String>> process = new LinkedList<List<String>>();
		List<Set<String>> dics = new LinkedList<Set<String>>();
		List<Integer> lengths = new LinkedList<Integer>();
		List<String> list = new LinkedList<String>();
		list.add(start);
		process.add(list);
		dics.add(dict);
		lengths.add(1);
		
		int minLen = Integer.MAX_VALUE;
		
		while(!process.isEmpty()){
			
			List<String> l = process.remove(0);
			Set<String> d = dics.remove(0);
			int len = lengths.remove(0);
			if(len>=minLen || d.isEmpty()){
				continue;
			}
			for (int i = 0; i < start.length(); i++) {
				char[] ca = l.get(l.size()-1).toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					ca[i] = c;
					String str = new String(ca);
					
					if(str.equals(end)){
						List<String> nl = new LinkedList<String>(l);
						//Set<String> nd = new HashSet<String>(d);
						minLen = Math.min(minLen, len+1);
						nl.add(str);
						result.add(nl);
					}
					
					if(d.contains(str)){
						List<String> nl = new LinkedList<String>(l);
						Set<String> nd = new HashSet<String>(d);
						nl.add(str);
						nd.remove(str);
						process.add(nl);
						dics.add(nd);
						lengths.add(len+1);
					}
				}

			}
			
			
		}
		return result;
	}
}
