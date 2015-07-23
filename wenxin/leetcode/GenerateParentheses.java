/**
 * 
 */
package wenxin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 22.
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class GenerateParentheses {
	
	public static void main(String[] args){
		GenerateParentheses instance = new GenerateParentheses();
		System.out.println(instance.generateParenthesis(3));
	}

	
    public List<String> generateParenthesis(int n) {
    	ArrayList<String> result = new ArrayList<String>();
    	dfs(result, "", n, n);
        return result;
    }
    
    public void dfs(List<String> result, String str, int left, int right){
    	
    	if(left==0 && right==0){
    		result.add(str);
    		return;
    	}
    	
    	if(left>=right){
    		dfs(result, str+"(", left - 1, right);
    	}else{
    		if(left>0){
    			dfs(result, str+"(", left - 1, right);
    		}
    		if(right>0){
    			dfs(result, str+")", left, right - 1);
    		}
    	}
    }
}
