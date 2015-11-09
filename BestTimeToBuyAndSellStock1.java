// Say you have an array for which the ith element is the price of a given stock on day i.

// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
// design an algorithm to find the maximum profit.


public class BestTimeToBuyAndSellStock1{
	public static int maxProfit(int[] prices){
		if(prices.length <= 0){
			return 0;
		}

		int min = prices[0];
		int profit = 0;

		for(int i=0; i<prices.length; i++){
			if(prices[i] - min > profit){
				profit = prices[i] - min;
			}
			if(min > prices[i]){
				min = prices[i];
			}
		}

		return profit;
	}

	public static void main(String[] args) {
		int[] prices = {15, 20, 22, 18};
		System.out.println(maxProfit(prices));
	}
}
