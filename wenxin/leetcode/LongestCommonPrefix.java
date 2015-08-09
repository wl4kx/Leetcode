package wenxin.leetcode;

/*
 * problem 14.
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
        	return "";
        }
        String firstStr = strs[0];
    	int length = firstStr.length();
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i=0;i<length;i++){
    		char c = firstStr.charAt(i);
    		for(int j=1;j<strs.length;j++){
    			if(strs[j].length()<=j || strs[j].charAt(i)!=c){
    				return sb.toString();
    			}
    		}
    		sb.append(c);
    	}
    	return sb.toString();
    }
	
}
