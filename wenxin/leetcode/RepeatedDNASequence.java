/**
 * 
 */
package wenxin.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author liao.wenxin
 *
 */
/*
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class RepeatedDNASequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * key: use a 32 bit integer to represent each 10 character sequence.
	 * analysis: http://www.programcreek.com/2014/03/leetcode-repeated-dna-sequences-java/
	 */
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> result = new ArrayList<String>();

		int len = s.length();
		if (len < 10) {
			return result;
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);

		Set<Integer> temp = new HashSet<Integer>();
		Set<Integer> added = new HashSet<Integer>();

		int hash = 0;
		for (int i = 0; i < len; i++) {
			if (i < 9) {
				// each ACGT fit 2 bits, so left shift 2
				hash = (hash << 2) + map.get(s.charAt(i));
			} else {
				hash = (hash << 2) + map.get(s.charAt(i));
				// make length of hash to be 20
				hash = hash & (1 << 20) - 1;

				if (temp.contains(hash) && !added.contains(hash)) {
					result.add(s.substring(i - 9, i + 1));
					added.add(hash); // track added
				} else {
					temp.add(hash);
				}
			}

		}

		return result;
	}	

}
