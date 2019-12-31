package cn.wangx.leetcode.day01;

import java.util.HashSet;
import java.util.Set;

/**
 * Create by wangx On 2019/12/26
 **/
public class P03 {

}

class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int res = 0;
        int end = 0, start = 0;
        Set<Character> set = new HashSet<>();
        while (start < len && end < len){
            if (set.contains(s.charAt(end))){
                set.remove(s.charAt(start++));
            }else {
                set.add(s.charAt(end++));
                res = Math.max(res, end - start);
            }
        }
        return res;
    }
}
