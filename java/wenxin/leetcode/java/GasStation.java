/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
public class GasStation {

	/**
	 * @param args
	 */
	/*
	 * problem 134.
	 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * anaylysis from http://www.programcreek.com/2014/03/leetcode-gas-station-java/
	 */
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	


        for (int i = 0; i < gas.length; ) {
        	
        	int gasLeft = gas[i];
        	int count = 0;
        	while(count<gas.length){
        		int temp =count;
        		if(i+temp>=cost.length){
        			temp -= cost.length;
        		}
    			if(gasLeft>cost[i+temp]){
    				gasLeft -= cost[i+temp];
    				if((i+1+temp)>=cost.length){
    					gasLeft += gas[0];
    				}else{
    					gasLeft += gas[i+1+temp];
    				}
    				
    			}else{
    				/*
    				 * key is here!!!
    					i += count;
    					without this line, will exceeds time limit.
    					reason for this line is:
    					if A can not reach C in a the sequence of A-->B-->C, then B can not make it either.
    					Therefore, if A can reach B but not C, no need to start from B, instead start from C.
    				 */
    				i += count;
    				break;
    			}	
        		count++;
        	}
        	
        	if(count==gas.length){
        		return i;
        	}

		}
        
        
        return -1;
    }
	
}
