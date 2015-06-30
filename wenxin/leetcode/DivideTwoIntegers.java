package wenxin.leetcode;

import java.util.ArrayList;

public class DivideTwoIntegers{
	/*
	 *	Divide two integers without using multiplication, division and mod operator.
	 *	If it is overflow, return MAX_INT.
	 */
	public static void main(String[] args){
		System.out.println(divide(1004958205, -2137325331));
	}
	static ArrayList<Double> gap = new ArrayList<Double>();
	static ArrayList<Double> scaleArr = new ArrayList<Double>();
    public static int divide(int dividend, int divisor) {
    	/*
    	 * 40 / 8 = 5, 40 is dividend, 8 is divisor
    	 */
    	double dividendDouble = dividend;
    	double divisorDouble = divisor;
    	if(divisor == 0){
    		return Integer.MAX_VALUE;
    	}
    	boolean isNegative = false;
    	if(dividendDouble<0){
    		
    		if(divisorDouble<0){
    			divisorDouble = -divisorDouble;
    		}else{
    			isNegative = true;
    		}
    		dividendDouble = -dividendDouble;
    	}else{
    		if(divisorDouble<0){
    			isNegative = true;
    			divisorDouble = - divisorDouble;
    		}
    	}
    	if(divisorDouble > dividendDouble || divisorDouble == 0){
    		return 0;
    	}
    	
    	double result = 1;
    	double test = divisorDouble;
    	gap.add(divisorDouble);
    	scaleArr.add(1d);
    	int pointer = 0;
    	while(test < dividendDouble && (dividendDouble - test) >= divisorDouble){
    		
    		if(test+gap.get(pointer)>dividendDouble){
    			result = binarySearch(test, dividendDouble, divisorDouble, pointer);
    			break;
    		}else{
    			test = test+gap.get(pointer);
    			gap.add(gap.get(pointer)+gap.get(pointer));
    			scaleArr.add(scaleArr.get(pointer)+scaleArr.get(pointer));
    			pointer++;
    			result = result+result;
    		}
 		
    	}

    	if(isNegative)
    		result = -result;
    	if(result>Integer.MAX_VALUE){
    		return Integer.MAX_VALUE;
    	}else{
    		return (int) result;
    	}
    }
    
    public static double binarySearch(double start, double dividend, double divisor, int pointer){
    	double result = scaleArr.get(pointer);
    	double test = start;
    	boolean add = true;
    	while(true){
    		if(add){
    			test = test + gap.get(pointer);	
    			result = result + scaleArr.get(pointer);
    		}else{
    			test = test - gap.get(pointer);
    			result = result - scaleArr.get(pointer);
    		}
    		if(test > dividend){
    			add = false;
    		}else if(test == dividend){
    			return result;
    		}else if(test < dividend){
    			add = true;
    		}
    		if(add && (dividend - test< divisor)){
    			return result;
    		}else if(!add && (test - dividend<divisor)){
    			return --result;
    		}
			pointer--;
    	}    	
    }
	
}