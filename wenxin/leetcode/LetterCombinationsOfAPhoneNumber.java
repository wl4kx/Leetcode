package wenxin.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * problem 17.
 * Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsOfAPhoneNumber{
	
	public static HashMap<String, ArrayList<String>> phoneKeys = new HashMap<String, ArrayList<String>>();
	
	public static void main(String[] args){
		List<String> result = letterCombinations("23");
		for(String str : result){
			System.out.print(str+", ");
		}
	}
	
    public static List<String> letterCombinations(String digits) {
    	ArrayList<String> result = new ArrayList<String>();
    	if(digits.length()==0)
    		return result;
        ArrayList<String> two = new ArrayList<String>();
        two.add("a");
        two.add("b");
        two.add("c");
        ArrayList<String> three = new ArrayList<String>();
        three.add("d");
        three.add("e");
        three.add("f");
        ArrayList<String> four = new ArrayList<String>();
        four.add("g");
        four.add("h");
        four.add("i");
        ArrayList<String> five = new ArrayList<String>();
        five.add("j");
        five.add("k");
        five.add("l");
        ArrayList<String> six = new ArrayList<String>();
        six.add("m");
        six.add("n");
        six.add("o");
        ArrayList<String> seven = new ArrayList<String>();
        seven.add("p");
        seven.add("q");
        seven.add("r");
        seven.add("s");
        ArrayList<String> eight = new ArrayList<String>();
        eight.add("t");
        eight.add("u");
        eight.add("v");
        ArrayList<String> nine = new ArrayList<String>();
        nine.add("w");
        nine.add("x");
        nine.add("y");
        nine.add("z");
        phoneKeys.put("2", two);
        phoneKeys.put("3", three);
        phoneKeys.put("4", four);
        phoneKeys.put("5", five);
        phoneKeys.put("6", six);
        phoneKeys.put("7", seven);
        phoneKeys.put("8", eight);
        phoneKeys.put("9", nine);
        
        result.add("");
        getCombinations(result, digits);
        return result;
    }
    
    public static void getCombinations(ArrayList<String> result, String digits){
    	
    	if(digits.length()==0)
    		return;
    	
    	String thisnumber = digits.charAt(0) + "";
    	int size = result.size();
    	for(int i = 0 ; i<size; i++){
    		String str = result.remove(0);
    		for(String letter : phoneKeys.get(thisnumber)){
    			result.add(str+letter);
    		}
    	}
    	getCombinations(result, digits.substring(1));
    	
    }
	
    
}