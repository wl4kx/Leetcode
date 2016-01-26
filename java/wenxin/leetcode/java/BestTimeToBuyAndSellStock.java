/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 121.
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class BestTimeToBuyAndSellStock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
    public int maxProfit(int[] prices) {
        
    	int minPrice = Integer.MAX_VALUE;
    	int maxProfit = 0;
    	
    	for (int i = 0; i < prices.length; i++) {
			int currentPrice = prices[i];
			if(currentPrice<minPrice){
				minPrice = currentPrice;
			}
			int profit = currentPrice - minPrice;
			maxProfit = Math.max(profit, maxProfit);
			
			
		}
    	
    	return maxProfit;
    	
    	
    }
}
