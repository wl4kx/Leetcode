/**
 * 
 */
package wenxin.leetcode;

/**
 * @author liao.wenxin
 *
 */
/*
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.
 */
public class BitwiseANDOfNumbersRange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitwiseANDOfNumbersRange instance = new BitwiseANDOfNumbersRange();
		System.out.println(instance.rangeBitwiseAnd(0, 2147483647));
	}
	
	public int rangeBitwiseAnd(int m, int n) {
		while (n > m) {
			n = n & n - 1;
		}
		return m & n;
	}
	
	// key is to find common left part.
	// for example, 5 and 7 in binary are 101 and 111, common left part is 100. So result is 4.
	// below solution is using this idea.
	  public int rangeBitwiseAnd2(int m, int n) {
	        int i = 0;
	        while (m != n) {
	            m >>= 1;
	            n >>= 1;
	            ++i;
	        }
	        return (m << i);
	    }

}
