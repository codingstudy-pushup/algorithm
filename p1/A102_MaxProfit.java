package topInterview;

public class MaxProfit {

	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit(prices));
	}

	//1. Brute Force
	public int solve(int[] prices) {
		int maxProfit = 0;

		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				int profit = prices[j] - prices[i];
				if (profit > maxProfit)
					maxProfit = profit;
			}
		}
		return maxProfit;
	}

	//2
	public static int maxProfit(int[] prices) {
		if (prices.length == 0)
			return 0;

		int max = 0;
		int sofarMin = prices[0];
		
		for (int i = 0; i < prices.length; ++i) {
			if (sofarMin < prices[i] ) {
				max = Math.max(max, prices[i] - sofarMin);
			} else {
				sofarMin = prices[i];
			}
		}
		return max;
	}

}
