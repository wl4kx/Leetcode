package wenxin.leetcode;

/*
 * Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
 */
public class PowerOfThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PowerOfThree instance = new PowerOfThree();
		System.out.println(instance.isPowerOfThree(243));
	}

	/*
	 * if n = 3^d
	 * then log(n) = log(3^d)
	 * then log(n) = d*log(3)
	 * then d = log(n)/log(3)
	 * d has to be an integer because n is an integer.
	 */
	public boolean isPowerOfThree(int n) {
		if(n==0){
			return false;
		}
		long d = Math.round(Math.log(n)/Math.log(3));
		if(n == Math.pow(3, d)){
			return true;
		}
		return false;
	}

}
