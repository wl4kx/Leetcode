/**
 * 
 */
package wenxin.leetcode.java;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 123.
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockIII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BestTimeToBuyAndSellStockIII instance = new BestTimeToBuyAndSellStockIII();
		int[] ia = {2,1,2,0,1};
		System.out.println(instance.maxProfit(ia));

	}
	
	/*
	 * analysis, scan twice. First record max profit before day i. Second record max profit after day i.
	 */
    public int maxProfit(int[] prices) {
        if(prices.length==0){
        	return 0;
        }
    	int max = 0;
    	int minPrice = Integer.MAX_VALUE;

        int[] before = new int[prices.length];
        int[] after = new int[prices.length];
        
    	for (int i = 0; i < prices.length; i++) {

			int currentPrice = prices[i];
			if(currentPrice<minPrice){
				minPrice = currentPrice;
			}
			int profit = currentPrice - minPrice;
			max = Math.max(profit, max);
			before[i] = max;
		}
    	
    	max = 0;
    	int maxPrice = Integer.MIN_VALUE;
    	for (int i = prices.length-1; i >=0; i--) {
			int currentPrice = prices[i];
			if(currentPrice>maxPrice){
				maxPrice = currentPrice;
			}
			int profit = maxPrice - currentPrice;
			max = Math.max(profit, max);
			after[i] = max;
		}
    	
    	max =0;
    	for (int i = 0; i < prices.length; i++) {
			max = Math.max(max, before[i] + after[i]);
		}
    	return max;
    }

}
