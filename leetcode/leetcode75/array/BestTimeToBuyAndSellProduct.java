package com.leetcode.leetcode75.array;

public class BestTimeToBuyAndSellProduct {

    public static int maxProfit(int[] prices) {

        int buy = prices[0],sell = prices[0],result = 0;

        for(int i =1 ;i<prices.length;i++){
            if(prices[i] < buy){
                buy = prices[i];
                sell=buy;
            }
            else if(prices[i]>sell){
                sell=prices[i];
            }
            result = Math.max(result, sell-buy);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] stocks = {9,2,1,9,0,6,7};
        int result = maxProfit(stocks);
        System.out.println(result);
    }
}
