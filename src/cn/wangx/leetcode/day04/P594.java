package cn.wangx.leetcode.day04;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by wangx On 2019/12/29
 * 594. 最长和谐子序列
 **/
public class P594 {
    public int findLHS(int[] nums) {
        int ans = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length ; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for (int key : map.keySet()){
            if (map.containsKey(key+1)){
                sum = map.get(key) + map.get(key+1);
                ans = Math.max(ans,sum);
            }
        }
        return ans;
    }
}
