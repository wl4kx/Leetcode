package wenxin.leetcode.java;

/*
 * problem 91.
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 */
public class DecodeWays {
	
	public static void main(String[] args){
		System.out.print(numDecodings("11"));
	}
	
    public static int numDecodings(String s) {
    	if(s.equals(""))
    		return 0;
    	int[] map = new int[s.length()];
    	for(int i=0;i<s.length();i++){
    		map[i]=-1;
    	}
		return findWaysDP(s, map);
        
    }
    
    
    public static int findWaysDP(String s, int[] map){
    	if(s.length()<0)
    		return 0;
    	if(s.length()==0)
    		return 1;
    	if(map[s.length()-1]!=-1)
    		return map[s.length()-1];
    	
    	char last = 'a',secondLast='b';
    	if(s.length()-1>=0)
    		last = s.charAt(s.length()-1);
    	if(s.length()-2>=0)
    		secondLast = s.charAt(s.length()-2);
    	
    	int i1 = 0;
    	int i2 = 0;

    	if(last!='a'&&last>='1'&&last<='9')
    		i1 = findWaysDP(s.substring(0,s.length()-1), map);
    	if(secondLast=='1'||(secondLast=='2'&&last<='6'))
    		i2 = findWaysDP(s.substring(0,s.length()-2), map);
    	map[s.length()-1] = i1+i2;
    	return i1+i2;
    }
    /*
'A' -> 1
'B' -> 2
...
'J' -> 9
'K' -> 10Æ’Æ�??
'Z' -> 26Æ’Ã�F
     */
}
