package cn.wangx.leetcode.day07;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by wangx On 2020/1/1
 * 1281. 整数的各位积和之差
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 **/
public class P1281 {
    public int subtractProductAndSum(int n) {
        List<Integer> list = new ArrayList<>();
        int sum = 0,multi = 1;
        while (n>0){
            int tmp = n % 10;
            n = n / 10;
            list.add(tmp);
        }
        for (int tmp:list){
            sum+=tmp;
            multi*=tmp;
        }
        return multi - sum;
    }
}
