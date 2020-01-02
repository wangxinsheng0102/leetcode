package cn.wangx.leetcode.day07;

/**
 * Create by wangx On 2020/1/1
 **/
public class P357 {
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[11];
        if (n == 0){
            return 1;
        }else if ( n == 1){
            return 10;
        }else if (n==2){
            return 91;
        }
        dp[1] = 10;
        dp[2] = 81;
        for (int i = 3; i <= n ; i++) {
            dp[i] = dp[i-1]*(11-i);
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum+=dp[i];
        }
        return sum;
    }
}
