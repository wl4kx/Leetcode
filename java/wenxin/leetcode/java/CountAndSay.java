/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 38.
 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 */
public class CountAndSay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountAndSay instance = new CountAndSay();
		System.out.println(instance.countAndSay(2));

	}

	public String countAndSay(int n) {

		String num = "1";
		for (int i = 1; i < n; i++) {
			num = process(num);
		}
		return num;
	}

	public String process(String str){
		StringBuilder result = new StringBuilder("");
		int count = 1;
		char pre = str.charAt(0);
		for (int i = 1; i < str.length(); i++) {
			if(str.charAt(i)==pre){
				count++;
			}else{
				result.append(count);
				result.append(pre);
				count = 1;
				pre = str.charAt(i);
			}
		}
		result.append(count);
		result.append(pre);
		
		return result.toString();
			
	}
	
}
