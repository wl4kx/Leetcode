/**
 * 
 */
package wenxin.leetcode.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liao.wenxin
 *
 */
public class RestoreIPAddresses {

	/**
	 * @param args
	 */
	/*
	 * problem 93.
	 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
	 */
	public static void main(String[] args) {
		String input = "010010";
		List<String> result = restoreIpAddresses(input);
		for(String s : result){
			System.out.print(s+"  ");
		}
	
	}
    public static List<String> restoreIpAddresses(String s) {
    	
    	
    	if(s.length()>12)
    		return new ArrayList<String>();
    	
    	List<String> result = new ArrayList<String>();
        
    	ArrayList<List<String>> process = new ArrayList<List<String>>();
    	ArrayList<String> aSolution = new ArrayList<String>();
    	//aSolution.add("");
    	ArrayList<Integer> indice= new ArrayList<Integer>();
    	
    	process.add(aSolution);
    	indice.add(0);
    	
    	while(process.size()>0){
    		Integer index = indice.remove(0);
    		List<String> currentStrList = process.remove(0);
    		//String str = currentStrList.remove(currentStrList.size()-1);
    		
    		int i = index;
    		
    		while(i<s.length()){
    			String numStr = s.substring(index, i+1);
    			if(numStr.length()>1 && numStr.startsWith("0")){
    				break;
    			}
    			Integer thisNum = Integer.parseInt(numStr);
    			List<String> newStrList = new ArrayList<String>(currentStrList);
        		if(thisNum<256){
        			
        			newStrList.add(thisNum+"");
        			
        			if(newStrList.size()==4){
        				if(i==s.length()-1){
            	    		String resultStr = newStrList.get(0)+"."+newStrList.get(1)+"."+newStrList.get(2)+"."+newStrList.get(3);
                    		result.add(resultStr);
        				}

                		i++;
        			}else{
            			
            			process.add(newStrList);
            			indice.add(++i);
        			}

        		}else{
        			break;
        		}
    		}
 		
    	}
    	
    	return result;
    	
    }
}
