package wenxin.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {
	
	public static void main(String[] args){
		System.out.println(partition("aab"));
	}
	
    public static List<List<String>> partition(String s) {
    	List<List<String>> listOfList = new ArrayList<List<String>>();

    	if(s.length()==0){
    		LinkedList<String> list = new LinkedList<String>();
    		listOfList.add(list);
    		return listOfList;
    	}
    	for(int i=1;i<=s.length();i++){
    		if(isPalindrome(s.substring(0, i))){
    			List<List<String>> listlist= partition(s.substring(i));
    			for(List<String> listofstring: listlist) {
    				((LinkedList<String>)listofstring).addFirst(s.substring(0, i));
    			}
    			listOfList.addAll(listlist);
    		}
    	}
    	
    	
		return listOfList;
    	
    }

    
    public static boolean isPalindrome(String s){
    	int pointer1 = 0;
    	int pointer2 = s.length()-1;
    	
    	while(pointer1<pointer2){
    		if(s.charAt(pointer1)!=s.charAt(pointer2))
    			return false;
    		pointer1++;pointer2--;
    	}
    	
    	
    	return true;
    }
}
