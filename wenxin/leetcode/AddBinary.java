package wenxin.leetcode;

public class AddBinary {
	/*
	 * problem 67.
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
	 */
	public String addBinary(String a, String b) {

		int lengtha = a.length();
		int lengthb = b.length();

		if (lengtha == 0) {
			return b;
		}
		if (lengthb == 0) {
			return a;
		}

		StringBuilder result = new StringBuilder("");
		
		int ia = lengtha-1;
		int ib = lengthb-1;
		int carry = 0;
		while(ia>=0 || ib>=0 || carry>0){
			int va = 0;
			int vb = 0;
			if(ia>=0){
				va = (a.charAt(ia) - '0');
				ia--;
			}
			if(ib>=0){
				vb = (b.charAt(ib) - '0');
				ib--;
			}
			int sum = va + vb + carry;
			if(sum==3){
				carry = 1;
				result.append("1");
			}else if(sum==2){
				carry = 1;
				result.append("0");
			}else if(sum==1){
				carry = 0;
				result.append("1");
			}else{
				carry = 0;
				result.append("0");
			}

		}
		
		return result.reverse().toString();

	}
    
    public static void main(String[] args){
    	AddBinary instance = new AddBinary();
    	
    	System.out.print(instance.addBinary("00","00"));
    }
}
