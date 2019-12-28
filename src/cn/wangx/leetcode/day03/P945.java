package cn.wangx.leetcode.day03;

import java.util.Arrays;

/**
 * Create by wangx On 2019/12/28
 * 945. 使数组唯一的最小增量
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 *
 **/
public class P945 {

    public static void main(String[] args) {
        P945 p945 = new P945();
        int[] A = new int[6];
        //3,2,1,2,1,7
        A[0] = 3;
        A[1] = 2;
        A[2] = 1;
        A[3] = 2;
        A[4] = 1;
        A[5] = 7;
        int i = p945.minIncrementForUnique(A);
        System.out.println(i);
    }

    public int minIncrementForUnique(int[] A) {
        int ans = 0;
        Arrays.sort(A);
        if (A.length <= 1) return ans;
        int len = A.length;
        System.out.println(len);
        for (int i = 0; i < len - 1; i++) {
            if (A[i]>=A[i+1]){
                int check = A[i] - A[i+1] + 1;
                A[i+1] = A[i] + 1;
                ans += check;
            }
        }
        return  ans;
    }

}
