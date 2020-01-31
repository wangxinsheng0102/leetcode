package cn.wangx.leetcode.day11;

/**
 * 1304. 和为零的N个唯一整数
 */
public class P1304 {
    class Solution {
        public int[] sumZero(int n) {
            int[] ans = new int[n];
            for (int i = 0; i < n/2 ; i++) {
                ans[i*2] = i+1;
                ans[i*2+1] = -(i+1);
            }
            return ans;
        }
    }
}
