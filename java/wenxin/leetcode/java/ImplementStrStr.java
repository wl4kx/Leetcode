package wenxin.leetcode.java;

/*
 * problem 28.
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Update (2014-11-02):
The signature of the function had been updated to return the index instead of the pointer. If you still see your function signature returns a char * or String, please click the reload button  to reset your code definition.
 */
public class ImplementStrStr {

	public int strStr(String haystack, String needle) {
		for (int i = 0;; i++) {
			for (int j = 0;; j++) {
				if (j == needle.length())
					return i;
				if (i + j == haystack.length())
					return -1;
				if (needle.charAt(j) != haystack.charAt(i + j))
					break;
			}
		}
	}
	
	  public static void main(String[] args) {
	      String a = "abbc";
	      String b = "bc";
	     System.out.println(strstr(a, b));
	  }
	  
	  public static boolean strstr(String a, String b){
	    
	    for(int i=0;i<a.length()-b.length() +1 ;i++){
	    	int n = i;
	      for(int j=0;j<b.length();j++){
	        
	        if(a.charAt(n)!=b.charAt(j)){
	          break;
	        }else if(j==b.length()-1){
	          return true;
	        }else{
	        	n++;	
	        }
	        
	      }
	      
	    }
	    
	    return false;
	    
	  }

}
