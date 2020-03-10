package cn.wangx.leetcode.day17;
// 买卖股票的最佳时机
public class P121 {


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxProfit(new int[]{});
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        int minprice = prices[0];
        dp[0] = 0;
        for (int i = 1; i < n ; i++) {
            minprice = Math.min(minprice,prices[i]);
            dp[i] = Math.max(dp[i-1], prices[i] - minprice);
        }
        return dp[n-1];
    }
}
