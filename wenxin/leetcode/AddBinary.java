package wenxin.leetcode;

public class AddBinary {
	/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
	 */
    public static String addBinary(String a, String b) {
    	char[] ca1= new StringBuilder(a).reverse().toString().toCharArray();
    	char[] ca2= new StringBuilder(b).reverse().toString().toCharArray();
    	int length = ca1.length>ca2.length?ca1.length:ca2.length;
    	int carry = 0;
    	String result ="";
    	for(int i = 0;i<length;i++){
    		int i1=0;
    		int i2=0;
    		if(i<ca1.length){
    			i1=Integer.parseInt(""+ca1[i]);
    		}
    		if(i<ca2.length){
    			i2=Integer.parseInt(""+ca2[i]);
    		}
    		int sum = i1+i2+carry;
    		if(sum>1){
    			if(sum==2){
    				sum=0;
    			}
    			if(sum==3){
    				sum=1;
    			}
    			carry=1;
    		}else{
    			carry=0;
    		}
    		result+=sum;
    		new Double(Math.sqrt(1)).intValue();
    	}
if(carry==1){
	result+="1";
}
    	
    	return new StringBuilder(result).reverse().toString();
    }
    
    public static void main(String[] args){
    	System.out.print(addBinary("0","0"));
    }
}
