/**
 * 
 */
package wenxin.leetcode;

/**
 * @author liao.wenxin
 *
 */
/*
 * Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeroes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FactorialTrailingZeroes instance = new FactorialTrailingZeroes();
		System.out.println(instance.trailingZeroes(10));
	}

	/*
	 * KEY: find how many 5 as factor in n.
	 * analysis: http://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/
	 */
    public int trailingZeroes(int n) {
        // Initialize result
        int count = 0;
     
        // Keep dividing n by powers of 5 and update count
        for (long i=5; n/i>=1; i *= 5)
              count += n/i;
     
        return count;
    }
    
}
