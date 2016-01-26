package wenxin.leetcode.java;

/*
 * problem 125.
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidatePalindrome {
    public boolean isPalindrome(String s) {

    	if(s==""){
    		return true;
    	}
    	s=s.toLowerCase();
        char[] ca = s.toCharArray();
        boolean bo = true;
        for(int i=0, j = ca.length-1;i<j;i++,j--){
        	String a = Character.toString(ca[i]);
        	String b = Character.toString(ca[j]);
        	while(!a.matches("[a-z0-9]")){
        		i++;
        		if(i>j){
        			break;
        		}
        		a = Character.toString(ca[i]);
        	}
        	while(!b.matches("[a-z0-9]")){
        		j--;
        		if(i>j){
        			break;
        		}
        		b = Character.toString(ca[j]);
        	}
        	
        	if(i<=j && ca[i]!=ca[j]){
        		bo=false;
        		break;
        	}
        	
        }
        return bo;
        
    
    }
}
