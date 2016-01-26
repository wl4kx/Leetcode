package wenxin.leetcode.java;

/*
 * problem 70.
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {

//	Map<Integer, Integer> result = new HashMap<Integer, Integer>();
//	public int climbStairs(int n) {
//		
//		if (n == 1)
//			return 1;
//		if (n == 2)
//			return 2;
//		if (result.containsKey(n))
//			return result.get(n);
//
//		int r1 = climbStairs(n - 1);
//		int r2 = climbStairs(n - 2);
//		int r = r1 + r2;
//		result.put(n, r);
//
//		return r;
//
//	}
	
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
        
        return dp[n];
    }
	
}
