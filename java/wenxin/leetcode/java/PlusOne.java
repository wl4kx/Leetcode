/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 66. http://www.programcreek.com/2014/05/leetcode-plus-one-java/
 * Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] plusOne(int[] digits) {
		int len = digits.length;
		boolean flag = true; // flag if the digit needs to be changed
	 
		for (int i = len - 1; i >= 0; i--) {
			if (flag) {
				if (digits[i] == 9) {
					digits[i] = 0;
				} else {
					digits[i] = digits[i] + 1;
					flag = false;
				}
	 
				if (i == 0 && digits[i] == 0) {
					int[] y = new int[len + 1];
					y[0] = 1;
					for (int j = 1; j <= len; j++) {
						y[j] = digits[j - 1];
					}
					digits = y;
				}
			}
		}
	 
		return digits;
	}
}
