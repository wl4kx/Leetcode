/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
/*
 * Write a function that takes an unsigned integer and returns the number of ?1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ?11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */
public class NumberOf1Bits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NumberOf1Bits instance = new NumberOf1Bits();
		//System.out.println(instance.hammingWeight(2147483648));

	}

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	int count = 0;
    	while(n!=0){
            int i = n & 1;
            if(i==1){
            	count++;
            }	
            n = n>>>1;
    	}
    	return count;
    }
    
}
