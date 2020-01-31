package cn.wangx.leetcode.day11;

public class P397 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.integerReplacement(2147483647);
        System.out.println(i);
    }


    static class Solution {
        public int integerReplacement(int n) {
            return dfs(n);
        }

        public int dfs(int n){
            if(n == 1) return 0;
            if (n%2==0) {
                return 1 + dfs(n / 2);
            }else {
                return 1 + Math.min(dfs(n+1), dfs(n-1));
            }
        }
    }
}
