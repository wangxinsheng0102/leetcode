package cn.wangx.leetcode.day06;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by wangx On 2019/12/31
 **/
public class P967 {
    List<Integer> ansList = new ArrayList<>();
    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1) return new int[]{0,1,2,3,4,5,6,7,8,9};
        for (int i = 1; i < 10; i++) {
            dfs(i,i,N - 1,K);
        }
        int len = ansList.size();
        int []res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = ansList.get(i);
        }
        return res;
    }

    void dfs(int val,int pre,int N,int K){
        if (N==0){
            ansList.add(val);
            return;
        }
        for (int i = 0; i <= 9 ; i++) {
            if (Math.abs(pre - i) == K){
                dfs(val*10+i,i,N-1,K);
            }
        }
    }
}
