package wenxin.leetcode.java;

/*
 * problem 27.
 * Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {


    	 int[] result = new int[A.length];
    	 int length = A.length;
    	 int count = 0;

    	    	for(int i =0;i<A.length;i++){
    	    		
    	    		if(A[i]!=elem){
    	    			result[count] = A[i];
    	    			count++;
    	    		}    else{
    	    			length--;
    	    		}
    	    	}
    	for(int i =0;i<length;i++){
    		A[i] = result[i];
    	}
    			return length;
    	        
    	    
        
    }
}
