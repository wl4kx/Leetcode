/**
 * 
 */
package wenxin.leetcode.java;

import java.util.Stack;

/**
 * @author liao.wenxin
 *
 */
/*
 * Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
 */
public class BasicCalculatorII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BasicCalculatorII instance = new BasicCalculatorII();
		System.out.println(instance.calculate("1*2-3/4+5*6-7*8+9/10"));

	}
	
    public int calculate(String s) {
    	s = s.replaceAll(" ", "");
    	if(s.length()==0){
    		return 0;
    	}
        Stack<String> st = new Stack<String>();
        st.push(s.charAt(0)+"");
        for (int i = 1; i < s.length(); i++) {
        	if(s.charAt(i)==' '){
        		continue;
        	}
			if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
				if(isNumber(st.peek())){
					String newNum = st.pop()+s.charAt(i);
					st.push(newNum);
				}else{
					if(st.peek().equals("*")||st.peek().equals("/")){
						int result;
						String operation = st.pop();
						int pre = Integer.parseInt(st.pop());
						String curString = s.charAt(i)+"";
						while(i+1<s.length()&&isNumber(s.charAt(i+1)+"")){
							curString=curString+s.charAt(i+1);
							i++;
						}
						int curNum = Integer.parseInt(curString);
						if(operation.equals("*")){
							result = curNum * pre;
						}else{
							result = pre / curNum;
						}
						st.push(result+"");
					}else{
						st.push(s.charAt(i)+"");
					}
				}
			}else{
				st.push(s.charAt(i)+"");
			}
		}
        Stack<String> temp = new Stack<String>();
        while(!st.isEmpty()){
        	temp.push(st.pop());
        }
        long result = Integer.parseInt(temp.pop());

        while(!temp.isEmpty()){
        	String operation = temp.pop();
        	long pre = Long.parseLong(temp.pop());
        	if(operation.equals("+")){
        		result = pre + result;
        	}else{
        		result = result - pre;
        	}
        }
        
        return (int)result;
        
    }
    
    private boolean isNumber(String s){
    	return !s.equals("+")&&!s.equals("-")&&!s.equals("*")&&!s.equals("/");
    }

}
