package wenxin.leetcode;

/*
 * problem 9.
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrome(1));

	}

	public static boolean isPalindrome(int x) {
		// reverse it and see if they are same.
		int original = x;
		int reverse = 0;

		while (x > 0) {
			int digit = x % 10;
			reverse = reverse * 10 + digit;
			x = x / 10;
		}
		return original == reverse;
	}

}
