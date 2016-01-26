/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
/*
 * Given an integer, write a function to determine if it is a power of two.
 */
public class PowerOfTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PowerOfTwo instance = new PowerOfTwo();
		System.out.println(instance.isPowerOfTwo(1026));

	}
	
    public boolean isPowerOfTwo(int n) {
        if(n==0){
        	return false;
        }
        while(n!=1){
        	if(n%2!=0){
        		return false;
        	}
        	n=n>>1;
        }
        return true;
    }

}
