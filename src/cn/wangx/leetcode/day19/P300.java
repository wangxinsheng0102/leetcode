package cn.wangx.leetcode.day19;

import java.util.Arrays;

public class P300 {

}

class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int ans = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < len ; i++) {
            for (int j = 0; j < i ; j++) {
                if (nums[i] < nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        for (int i = 0; i < len ; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
