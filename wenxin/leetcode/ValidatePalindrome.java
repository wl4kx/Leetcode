package wenxin.leetcode;


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
