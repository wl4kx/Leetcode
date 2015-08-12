/**
 * 
 */
package wenxin.leetcode;

/**
 * @author liao.wenxin
 *
 */
/*
 * problem 122.
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int maxProfit(int[] prices) {
    	if(prices.length==0){
    		return 0;
    	}
    	int max = 0;
        int pre = prices[0];
        for (int i = 1; i < prices.length; i++) {
			int cur = prices[i];
			if(cur>pre){
				max += cur-pre;
			}
			pre = cur;
		}
        
        return max;
    }
	
}
