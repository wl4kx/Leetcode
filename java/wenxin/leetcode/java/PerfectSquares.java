/**
 * 
 */
package wenxin.leetcode.java;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wenxin liao
 *
 */
/*
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
 * return 2 because 13 = 4 + 9.
 */
public class PerfectSquares {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PerfectSquares instance = new PerfectSquares();

		System.out.println(instance.numSquares(13));
	}

	public int numSquares(int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		return helper(n, map);
	}

	public int helper(int n, Map<Integer, Integer> map){
		if(map.containsKey(n))
			return map.get(n);
		int largestRoot = new Double(Math.sqrt(n)).intValue();
		int least = n;
		for(int i=largestRoot;i>0;i--){
			int current = 1 + helper(n-i*i, map);
			least = Math.min(least, current);
		}
		map.put(n, least);
		return least;
	}
	
	//better solution
	public int numSquares2(int n) {
		int[] record = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			record[i] = i;
			for (int j = 1; j * j <= i; j++) {
				if (record[i - j * j] + 1 < record[i])
					record[i] = record[i - j * j] + 1;
			}
		}
		return record[n];
	}

}
