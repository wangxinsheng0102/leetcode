package cn.wangx.leetcode.day12;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class P395 {
    public int longestSubstring(String s, int k) {
        int len = s.length();
        if (len == 0 || k > len) return 0;
        if (k < 2) return len;

        return count(s.toCharArray(), k, 0, len - 1);
    }

    public int count(char[] chars, int k,int p1,int p2){
        if (p2 - p1 + 1 < k) return 0;
        int[] times = new int[26];
        for (int i = p1; i<= p2;i++){
            times[chars[i] - 'a']++;
        }
        while (p2 - p1 + 1 >= k && times[chars[p1] - 'a'] < k){
            ++p1;
        }

        while (p2 - p1 + 1 >= k && times[chars[p2] - 'a'] < k){
            --p2;
        }
        if (p2 - p1 + 1 < k) return 0;
        for (int i = p1; i <= p2; ++i) {
            //  如果第i个不符合要求，切分成左右两段分别递归求得
            if (times[chars[i] - 'a'] < k) {
                return Math.max(count(chars, k, p1, i - 1), count(chars, k, i + 1, p2));
            }
        }
        return p2 - p1 + 1;
    }
}
