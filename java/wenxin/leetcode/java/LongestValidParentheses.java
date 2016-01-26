package wenxin.leetcode.java;

import java.util.Stack;

/*
 * problem 32.
 * 
 */
public class LongestValidParentheses {
/*
 * NOTE: key to solve this problem is that
 * stack stores index of each char! Not char itself.
 */
	public static void main(String[] args) {
		LongestValidParentheses instance = new LongestValidParentheses();
		System.out.println(instance.longestValidParentheses(")()())()()("));
	}
	
    public int longestValidParentheses(String s) {
        char[] ca = s.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        int longest = 0;
        for(int i =0;i<ca.length;i++){
        	char c = ca[i];
        	if(c=='('){
        		stack.push(i);
        	}else if(c==')'){
        		if(!stack.empty() && s.charAt(stack.peek())!=')'){
        			stack.pop();
        			if(stack.empty()){
        				longest = i + 1;
        			}else{
            			longest = Math.max(longest, i - stack.peek());
        			}

				}else{
					stack.push(i);
				}
        	}
        }
        return longest;
    }
}
