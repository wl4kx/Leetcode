/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 135. Solution from http://www.programcreek.com/2014/03/leetcode-candy-java/
 * There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
 */
public class Candy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Candy instance = new Candy();
		int[] ia = { 1, 2, 2 };
		System.out.println(instance.candy(ia));

	}

	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		}

		int[] candies = new int[ratings.length];
		candies[0] = 1;

		// from left to right
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candies[i] = candies[i - 1] + 1;
			} else {
				// if not ascending, assign 1
				candies[i] = 1;
			}
		}

		int result = candies[ratings.length - 1];

		// from right to left
		for (int i = ratings.length - 2; i >= 0; i--) {
			int cur = 1;
			if (ratings[i] > ratings[i + 1]) {
				cur = candies[i + 1] + 1;
			}

			result += Math.max(cur, candies[i]);
			candies[i] = cur;
		}

		return result;
	}

}
