/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 137.
 * Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumberII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * solution from http://www.programcreek.com/2012/12/leetcode-solution-of-single-number-in-java/
	 */
    public int singleNumber(int[] nums) {
    	int x = 0;
    	for (int a : nums) {
    		x = x ^ a;
    	}
    	return x;
    }

}
