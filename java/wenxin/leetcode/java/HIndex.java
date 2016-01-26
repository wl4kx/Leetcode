/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
/*
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N âˆ? h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.

Hint:

An easy approach is to sort the array first.
What are the possible values of h-index?
A faster approach is to use extra space.
 */
public class HIndex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HIndex instance = new HIndex();
		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(instance.hIndex(citations));
	}
	
	public int hIndex(int[] citations) {

		int[] s = new int[citations.length + 1];
		for (int i = 0; i < citations.length; i++)
			s[Math.min(citations.length, citations[i])]++;

		int sum = 0;
		for (int i = s.length - 1; i >= 0; i--) {
			sum += s[i];
			if (sum >= i)
				return i;
		}

		return 0;

	}

}
