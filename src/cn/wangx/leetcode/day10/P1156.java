package cn.wangx.leetcode.day10;

public class P1156 {

    public int maxRepOpt1(String text) {
        int len = text.length();
        char[] chars = text.toCharArray();
        int l = 0,r = 0;
        boolean chance = true;
        int ans = 0;
        int[] z = new int[26];
        for (char ch:chars){
            z[ch - 'a']++;
        }
        for (int i = 0; i < len - 1 ; i++) {
            int count = 1;
            int index = i;
            chance = true;
            char ch = chars[i];
            while (i < len - 1 && (chance || ch == chars[i+1])){
                if (ch!=chars[i+1]){
                    chance = false;
                    index = i;
                }
                i++;
                count++;
            }
            i = index;
            count = Math.min(z[ch-'a'], count);
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
