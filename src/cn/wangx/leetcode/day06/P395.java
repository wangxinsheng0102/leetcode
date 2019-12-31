package cn.wangx.leetcode.day06;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by wangx On 2019/12/31
 * not pass
 **/
public class P395 {
    public static void main(String[] args) {
        P395 p395 = new P395();
        String  s = "ababbc";
        int k = 2;
        int i = p395.longestSubstring(s, k);
        System.out.println(i);
    }
    public int longestSubstring(String s, int k) {
        int ans = 0;
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }
        for (Character c:map.keySet()){
            if (map.get(c) >= k){
                ans+=map.get(c);
            }
        }
        return ans;
    }
}
