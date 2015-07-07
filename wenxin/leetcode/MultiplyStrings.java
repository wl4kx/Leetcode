/**
 * 
 */
package wenxin.leetcode;


/**
 * @author liao.wenxin
 *
 */
public class MultiplyStrings {

	/**
	 * 43.Given two numbers represented as strings, return multiplication of the
	 * numbers as a string.
	 * 
	 * Note: The numbers can be arbitrarily large and are non-negative.
	 */
	public static void main(String[] args) {
		String num1 = "237";
		String num2 = "284";
		System.out.println(multiply(num1, num2));
	}

/*	public static String multiply(String num1, String num2) {
		char[] num1Arr = num1.toCharArray();
		char[] num2Arr = num2.toCharArray();
		ArrayList<ArrayList<Integer>> arr1 = new ArrayList<ArrayList<Integer>>();

		for (int i = num2Arr.length - 1; i >= 0; i--) {
			int trailingZeros = num2Arr.length - 1 - i;

			int multiplier2 = Integer.parseInt(num2Arr[i] + "");
			ArrayList<Integer> number2Add = new ArrayList<Integer>();

			int carry = 0;

			for (int j = num1Arr.length - 1; j >= 0; j--) {
				int multiplier1 = Integer.parseInt(num1Arr[j] + "");
				int product = multiplier1 * multiplier2 + carry;
				carry = product / 10;
				product = product % 10;
				number2Add.add(0, product);
			}
			if (carry != 0) {
				number2Add.add(0, carry);
			}
			for (int j = 0; j < trailingZeros; j++) {
				number2Add.add(0);
			}
			arr1.add(number2Add);
		}

		ArrayList<Integer> process = arr1.get(0);
		for (int i = 1; i < num2Arr.length; i++) {
			process = addTwoStrings(arr1.get(i), process);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < process.size(); i++) {
			sb.append(process.get(i));
		}
		String result = sb.toString();
		while(result.startsWith("0")){
			result.substring(1);
		}
		return result;
	}

	public static ArrayList<Integer> addTwoStrings(ArrayList<Integer> num1, ArrayList<Integer> num2) {
		int size1 = num1.size();
		int size2 = num2.size();
		int largerSize = size1 > size2 ? size1 : size2;

		ArrayList<Integer> result = new ArrayList<Integer>();
		int carry = 0;
		for (int i = 0; i < largerSize; i++) {
			int toAdd1 = 0;
			int toAdd2 = 0;
			if (i <= size1 - 1) {
				toAdd1 = num1.get(size1-1-i);
			}
			if (i <= size2 - 1) {
				toAdd2 = num2.get(size2-1-i);
			}
			int digitSum = toAdd1 + toAdd2 + carry;
			carry = digitSum / 10;
			digitSum = digitSum % 10;
			result.add(0, digitSum);
		}
		if (carry != 0) {
			result.add(0, carry);
		}
		return result;
	}*/
	public static String multiply(String num1, String num2) {
	    num1 = new StringBuilder(num1).reverse().toString();
	    num2 = new StringBuilder(num2).reverse().toString();
	    // even 99 * 99 is < 10000, so maximaly 4 digits
	    int[] d = new int[num1.length() + num2.length()];
	    for (int i = 0; i < num1.length(); i++) {
	        int a = num1.charAt(i) - '0';
	        for (int j = 0; j < num2.length(); j++) {
	            int b = num2.charAt(j) - '0';
	            d[i + j] += a * b;
	        }
	    }
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < d.length; i++) {
	        int digit = d[i] % 10;
	        int carry = d[i] / 10;
	        sb.insert(0, digit);
	        if (i < d.length - 1)
	            d[i + 1] += carry;
	        }
	    //trim starting zeros
	    while (sb.length() > 0 && sb.charAt(0) == '0') {
	        sb.deleteCharAt(0);
	    }
	    return sb.length() == 0 ? "0" : sb.toString();}
}
