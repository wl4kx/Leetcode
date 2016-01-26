/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 */
/*
 * problem 65. Solution from https://leetcodenotes.wordpress.com/2013/11/23/leetcode-valid-number/
 * Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 */
/*
 * 这就是典型的try and fail，尼玛谁知道�?么算是数�?么不算啊？让我用眼睛看我也不知道啊！总之，试出来的规则是这样的：
AeB代表A * 10 ^ B
A可以是小数也可以是整数，可以带正负号
.35, 00.神马的都算valid小数；就�?.”单独一个不�?
B必须是整数，可以带正负号
有e的话，A,B就必须同时存�?
算法就是按e把字符串split了，前面按A的法则做，后面按B做�??
 */
public class ValidNumber {
	public boolean isNumber(String s) {
	    s = s.trim(); 
	    if (s.length() > 0 && s.charAt(s.length() - 1) == 'e')
	        return false; //avoid "3e" which is false
	    String[] t = s.split("e");
	    if (t.length == 0 || t.length > 2)
	        return false;
	    boolean res = valid(t[0], false);
	    if (t.length > 1)
	        res = res && valid(t[1], true);
	    return res;
	}
	private boolean valid(String s, boolean hasDot) {
	    if (s.length() > 0 && (s.charAt(0) == '+' || s.charAt(0) == '-')) //avoid "1+", "+", "+."
	    s = s.substring(1);
	    char[] arr = s.toCharArray();
	    if (arr.length == 0 || s.equals("."))
	        return false;
	    for (int i = 0; i < arr.length; i++) {
	        if (arr[i] == '.') {
	            if (hasDot)
	                return false;
	            hasDot = true;
	        } else if (!('0' <= arr[i] && arr[i] <= '9')) {
	            return false;
	        }
	    }
	    return true;
	}
}
