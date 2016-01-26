package wenxin.leetcode.java;

import java.util.Stack;

/*
 * problem 20.
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
	
public class ValidParentheses {

    public static boolean isValid(String s) {
Stack<Character> stack = new Stack<Character>();    	
    	
    	if(s.length()<2)
    		return false;
    	char[] ca = s.toCharArray();

    	
    	//for(int i=0,j=s.length()-1;i<j;i++,j--){
    		
    	//}
    	char top = '0';
    	
    	for(int i =0;i<s.length();i++){
    		switch(ca[i]){
    		case '(':
    			stack.push(ca[i]);
    			break;
    		case ')':
    			if(top!='(')
    				return false;
    			else
    				stack.pop();
    			break;
    		case '[':
    			stack.push(ca[i]);
    			break;
    		case ']':
    			if(top!='[')
    				return false;
    			else
    				stack.pop();
    			break;
    		case '{':
    			stack.push(ca[i]);
    			break;
    		case '}':
    			if(top!='{')
    				return false;
    			else
    				stack.pop();
    			break;
    		}
    		if(!stack.empty())
    			top = stack.peek();
    	}
    	
    if(stack.empty())
        return true;
        else{
        	System.out.print(stack.pop());
        	return false;
        }
        
    }
}
