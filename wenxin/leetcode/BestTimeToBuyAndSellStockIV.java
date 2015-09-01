/**
 * 
 */
package wenxin.leetcode;

import java.util.HashSet;

/**
 * @author liao.wenxin
 *
 */
/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockIV {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if(len == 0) {
            return 0;
        }
        if (k >= len / 2) return quickSolve(prices);
        int[][] local = new int[len][k+1];      // local[i][j]: max profit till i day, j transactions,
                                                // where there is transaction happening on i day
        int[][] global = new int[len][k+1];     // global[i][j]: max profit across i days, j transactions
        for(int i=1; i<len; i++) {
            int diff = prices[i] - prices[i-1];
            for(int j=1; j<=k; j++) {
                local[i][j] = Math.max(global[i-1][j-1]+Math.max(diff,0), local[i-1][j]+diff);
                global[i][j] = Math.max(global[i-1][j], local[i][j]);
            }
        }
        return global[len-1][k];
    }
    
    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
    
    public int maxProfit2(int k, int[] prices){
    	
    	int totalProfit = 0;
    	HashSet<Integer> usedIndex = new HashSet<Integer>();
    	
    	for (int j = 0; j < k; j++) {
			
        	int minPrice = Integer.MAX_VALUE;
        	int maxProfit = 0;
        	int minIndex = -1;
        	int maxIndex = -1;
        	
        	for (int i = 0; i < prices.length; i++) {
        		if(usedIndex.contains(i))
        			continue;
    			int currentPrice = prices[i];
    			if(currentPrice<minPrice){
    				minPrice = currentPrice;
    				minIndex = i;
    			}
    			int profit = currentPrice - minPrice;
    			if(profit>maxProfit){
    				maxProfit = profit;
    				maxIndex = i;
    			}
    		}
    		
        	usedIndex.add(minIndex);
        	usedIndex.add(maxIndex);
        	totalProfit += maxProfit;
    		
		}
    	
    	
    	return totalProfit;

    	
    }
    
}
