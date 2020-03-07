package cn.wangx.leetcode.day15;

import java.util.ArrayList;
import java.util.List;

class Solution {
//    //有点暴力 O(n^2) 超时了
//    public int[][] findContinuousSequence(int target) {
//        int first = 0;
//        int n = 0;
//        int count = 0;
//        ArrayList<int[]> ret = new ArrayList<>();
//        for (int i = 1; i < target; i++) {
//            for (int j = 0; j <target; j++) {
//                first = i;
//                n = j;
//                int[] ans = new int[n];
//                int res = n * first + n*(n-1)/2;
//                if (res == target){
//                    for (int k = 0; k < n ; k++) {
//                        ans[k] = first + k;
//                    }
//                    ret.add(ans);
//                    count++;
//                }
//            }
//        }
//        return ret.toArray(new int[0][]);
//    }
    //滑动窗口
    public int[][] findContinuousSequence(int target) {
        int l = 1;//左边界
        int r = 1;//右边界
        int sum = 0;//窗口的数字的和
        List<int[]> ans = new ArrayList<>();
        while (l <= target / 2){
            if (sum < target){
                //右边界向右移动
                sum += r;
                r++;
            }else if (sum > target){
                //左边界向右移动
                sum-=l;
                l++;
            }else if (sum == target){
                int[] res = new int[r - l];
                for (int i = l; i < r ; i++) {
                    res[i - l] = i;
                }
                ans.add(res);
                //左边界向右移动
                sum -= l;
                l++;
            }
        }
        return ans.toArray(new int[0][]);
    }
}
public class mianshi57 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] sequence = solution.findContinuousSequence(15);
        for(int[] ans:sequence){
            for (int i:ans){
                System.out.print(i+"  ");
            }
            System.out.println();
        }
    }
}
