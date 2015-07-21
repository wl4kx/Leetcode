package wenxin.leetcode;

import java.util.HashMap;
import java.util.Map;


public class ClimbingStairs {
	Map<Integer, Integer> result = new HashMap<Integer, Integer>();
	
    public int climbStairs(int n) {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        if(result.containsKey(n))
        	return result.get(n);
        
        int r1 = climbStairs(n-1);
        int r2 = climbStairs(n-2);
        int r = r1+r2;
        result.put(n, r);
        
        return r;
    }
}
