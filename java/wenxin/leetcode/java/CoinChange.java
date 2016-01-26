package wenxin.leetcode.java;

import java.util.Arrays;

/*
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinChange instance = new CoinChange();
/*		int[] coins = {1, 2, 5};
		int amount = 11;*/
		int[] coins = {474, 83, 404, 3};
		int amount = 264;
		System.out.println("result is " + instance.coinChange(coins, amount));
	}

	public int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
		// dp[i] equals to min number of coins for amount i;
		int[] dp = new int[amount + 1];
		for (int i = 0; i < coins.length && coins[i] <= amount; i++) {
			dp[coins[i]] = 1;
		}

		for (int i = 1; i <= amount; i++) {
			if(dp[i]!=0)
				continue;
			double min = ((double)Integer.MAX_VALUE) + 1;
			for (int j = 0; j < coins.length && coins[j] < i; j++) {
				if(dp[i-coins[j]]!=-1)
					min = Math.min(min, 1+dp[i-coins[j]]);
			}
			if(min==((double)Integer.MAX_VALUE)+1){
				min = -1;
			}
			dp[i] = (int) min;
		}
		return dp[amount];
	}

}
