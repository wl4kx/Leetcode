package wenxin.leetcode;


public class ReverseInteger{
	
    public int reverse(int x) {/*
    	boolean isNegative = false;
    	if(x<0){
    		isNegative = true;
    		x = -x;
    	}
    	
        String s = x+"";
        
       	StringBuilder sb = new StringBuilder(s);
       	s=sb.reverse().toString();
       	int i = 0;
       	try{
       		i = Integer.parseInt(s);
       	}catch(Exception e){
       		return 0;
       	}
       	
       	
       	if(isNegative)
       		i = -i;
        return i;
    */
  
    	boolean isNegative = false;
    	if (x < 0) {
    		x = 0 - x;
    		isNegative = true;
    	}
     
    	int res = 0;
    	int p = x;
     
    	while (p > 0) {
    		int mod = p % 10;
    		p = p / 10;
    		if(res*10>2147483647 || res*10<-2147483647)
    			return 0;
    		res = res * 10 + mod;
    	}
     
    	if (isNegative) {
    		res = -res;
    	}
     
    	return res;	
    
    
    }
	
	
}