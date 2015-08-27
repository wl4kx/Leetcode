package wenxin.leetcode;

import java.util.Stack;

/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//key, use a stack.
	public int evalRPN(String[] tokens) {
		if(tokens.length==0){
			return 0;
		}
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < tokens.length; i++) {
			String s = tokens[i];

			if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
				int b = Integer.parseInt(stack.pop());
				int a = Integer.parseInt(stack.pop());
				int result = 0;
				switch (s) {
				case "+":
					result = a + b;
					break;
				case "-":
					result = a - b;
					break;
				case "*":
					result = a * b;
					break;
				case "/":
					result = a / b;
					break;

				}
				
				stack.push(result+"");
				
			} else {
				stack.push(s);
			}

		}
		
		return Integer.parseInt(stack.pop());

	}
	
}
