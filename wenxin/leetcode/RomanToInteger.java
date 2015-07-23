/**
 * 
 */
package wenxin.leetcode;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 13.
 * Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RomanToInteger instance = new RomanToInteger();
		System.out.println(instance.romanToInt("MCMLIV"));

	}

	public int romanToInt(String s) {
		int result = 0;
		int val[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String roman[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		while(s.length()>0){
			for (int i = 0; i < roman.length; i++) {
				if(s.startsWith(roman[i])){
					result += val[i];
					s = s.substring(roman[i].length());
				}
			}
		}
		return result;
	}
    
}
