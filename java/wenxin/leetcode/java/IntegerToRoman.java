/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 13. Solution from http://fisherlei.blogspot.com/2012/12/leetcode-integer-to-roman.html
 * Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntegerToRoman {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	

	}

	public String intToRoman(int num) {
		char symbol[] = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
		StringBuilder roman = new StringBuilder();
		int scale = 1000;
		for (int i = 6; i >= 0; i -= 2) {
			int digit = num / scale;
			if (digit != 0) {
				if (digit <= 3) {
					for (int j = 0; j < digit; j++) {
						roman.append(symbol[i]);
					}
				} else if (digit == 4) {
					roman.append(symbol[i]);
					roman.append(symbol[i + 1]);
				} else if (digit == 5) {
					roman.append(symbol[i + 1]);
				} else if (digit <= 8) {
					roman.append(symbol[i + 1]);
					for (int j = 0; j < digit - 5; j++) {
						roman.append(symbol[i]);
					}
				} else if (digit == 9) {
					roman.append(symbol[i]);
					roman.append(symbol[i + 2]);
				}
			}
			num = num % scale;
			scale /= 10;
		}
		return roman.toString();
	}
	
	//another solution.
	/*
	 *     string intToRoman(int num) {
        if(num<1 || num>3999) return NULL;
        string res;
        int val[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        string roman[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        for(int i=0; i<13;i++) {
            int count = num/val[i];
            num %= val[i];
            for(int j=0; j<count; j++)
                res += roman[i];
        }
        return res;
    }ï»?
	 */
}
