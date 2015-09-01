/**
 * 
 */
package wenxin.leetcode;

import java.util.HashSet;

/**
 * @author liao.wenxin
 *
 */
/*
 * Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
 */
public class HappyNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * following is from https://leetcode.com/discuss/53719/fastest-java-code-so-far-with-comments
	 * 4, 16, 20, 37, 42, 58, 89 are tested numbers that will result in unhappy numbers.
	 */
	   public boolean isHappy(int n) {
	        /* Base cases */

	        // A negative or zero value
	        // is not a valid input
	        // Return grumpily
	        if (n < 1) {
	            return false;
	        }

	        // You have entered
	        // the chain of despair.
	        // You will never be 
	        // happy again
	        if (n == 4
	        ||  n == 16
	        ||  n == 20
	        ||  n == 37
	        ||  n == 42
	        ||  n == 58
	        ||  n == 89
	        ||  n == 145) {
	            return false;
	        }
	        // Check Wikipedia for 
	        // the explanation of despairing numbers
	        // You don't need to remember all of them.
	        // Just remembering one of them will do

	        // You have achieved bliss
	        if (n == 1) {
	            return true;
	        }

	        // If none of the above
	        // Keep searching
	        return isHappy(getSumOfSquares(n));
	    }

	    private int getSumOfSquares(int num) {
	        int sum = 0;
	        while (num > 0) {
	            int digit = num % 10;
	            sum += digit * digit;
	            num /= 10;
	        }

	        return sum;
	    }
	    
	    /*
	     * below solution is from programcreek.
	     * basic idea is whenever we see a number that's existed before, stop and return false.
	     */
	    public boolean isHappy2(int n) {
	        HashSet<Integer> set = new HashSet<Integer>();
	     
	        while(!set.contains(n)){
	            set.add(n);
	     
	            n = sum(getDigits(n));
	            if (n == 1)
	                return true;
	        }
	     
	        return false;
	    }
	     
	    public int sum(int[] arr){
	        int sum = 0;
	        for(int i: arr){
	            sum = sum + i*i;
	        }
	        return sum;
	    }
	     
	    public int[] getDigits(int n){
	        String s = String.valueOf(n);
	        int[] result = new int[s.length()];
	        int i=0;
	     
	        while(n>0){
	            int m = n%10;
	            result[i++] = m;
	            n = n/10;
	        }
	     
	        return result;
	    }
}
