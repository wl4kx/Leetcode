/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
/*
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

Hint:

Expected runtime complexity is in O(log n) and the input is sorted.
 */
public class HIndexII {

	public static void main(String[] args) {
		HIndex instance = new HIndex();
		int[] citations = { 0, 1, 3, 5, 6 };
		System.out.println(instance.hIndex(citations));
	}

	public int hIndex(int[] citations) {
		for (int i = 0; i < citations.length; i++) {
			int remaining = citations.length - i;
			if (citations[i] >= remaining) {
				return Math.min(citations[i], remaining);
			}
		}
		return 0;
	}
}
