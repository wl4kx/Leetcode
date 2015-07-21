package wenxin.leetcode;

public class Sqrt {
    public static int sqrt(int x) {
    	long first = 0;
    	long last = x/2+1;
    	long pointer = 0;
    	
    	while(first<=last){
    		pointer = (first+last)/2;
        	System.out.println("first :"+first);
        	System.out.println("last :"+last);
        	System.out.println("pointer :"+pointer);
        	System.out.println("------------------------");
    		if(pointer*pointer==x){
    			return new Long(pointer).intValue();
    		}else if(pointer*pointer>x){
    			last=pointer-1;
    		}else if(pointer*pointer<x){
    			first=pointer+1;
    		}

    	}

    	return new Long(last).intValue();
    }
    
    public static void main(String[] args){
    	System.out.print(sqrt(1579205274));
    }
}
