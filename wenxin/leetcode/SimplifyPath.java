/**
 * 
 */
package wenxin.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 71.
 * Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class SimplifyPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//solution from http://www.programcreek.com/2014/04/leetcode-simplify-path-java/
	/*
	 * key is to use stack: for example, for original input /home/liaowenxin/
	 * stack should store "home", "liaowenxin".
	 */
    public String simplifyPath(String path) {
    	 Stack<String> stack = new Stack<String>();
    	 
    	    //stack.push(path.substring(0,1));
    	 
    	    while(path.length()> 0 && path.charAt(path.length()-1) =='/'){
    	        path = path.substring(0, path.length()-1);
    	    }
    	 
    	    int start = 0;
    	    for(int i=1; i<path.length(); i++){
    	        if(path.charAt(i) == '/'){
    	            stack.push(path.substring(start, i));
    	            start = i;
    	        }else if(i==path.length()-1){
    	            stack.push(path.substring(start));
    	        }
    	    }
    	 
    	    LinkedList<String> result = new LinkedList<String>();
    	    int back = 0;
    	    while(!stack.isEmpty()){
    	        String top = stack.pop();
    	 
    	        if(top.equals("/.") || top.equals("/")){
    	            //nothing
    	        }else if(top.equals("/..")){
    	            back++;
    	        }else{
    	            if(back > 0){
    	                back--;
    	            }else{
    	                result.push(top);
    	            }
    	        }
    	    }
    	 
    	    //if empty, return "/"
    	    if(result.isEmpty()){
    	        return "/";
    	    }
    	 
    	    StringBuilder sb = new StringBuilder();
    	    while(!result.isEmpty()){
    	        String s = result.pop();
    	        sb.append(s);
    	    }
    	 
    	    return sb.toString();
    }

}
