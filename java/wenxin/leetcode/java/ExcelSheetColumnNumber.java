/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
/*
 * Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
 */
public class ExcelSheetColumnNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int titleToNumber(String s) {
	 
	    int result = 0;
	    int i = s.length()-1;
	    int t = 0;
	    while(i >= 0){
	        char curr = s.charAt(i);
	        result = result + (int) Math.pow(26, t) * (curr-'A'+1);
	        t++;
	        i--;
	    }
	 
	    return result;
	}
}
