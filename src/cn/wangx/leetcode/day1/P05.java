package cn.wangx.leetcode.day1;

/**
 * Create by wangx On 2019/12/26
 **/
public class P05 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.longestPalindrome("cbbd");

    }

}
class Solution2 {
    int len2 = 0;
    int[] p = new int[10000];
    public String longestPalindrome(String s) {
        int index = 0;
        char[] init = init(s);
        manacher(init);
        int ans = 0;
        for (int i=0;i<len2;i++){
            if(ans<p[i]){
                ans = p[i];
                index = i;
            }
        }
        char[] res = new char[ans-1];
        int p = 0;
        for (int i = index - ans + 1; i < index + ans -1; i++) {
            if (init[i]!='#' && init[i]!='$' && init[i]!='*'){
                res[p++] = init[i];
            }
        }
        String str = String.valueOf(res);
        return str;
    }

    char[] init(String s){
        char[] chars = s.toCharArray();
        char[] str = new char[10000];
        str[0] = '$';
        str[1] = '#';
        for (int i = 0; i < chars.length; i++) {
            str[i*2+2] = chars[i];
            str[i*2+3] = '#';
        }
        len2 = chars.length*2 + 2;
        str[len2] = '*';
        return str;
    }

    void manacher(char[] str){
        int id = 0,mx = 0;
        for (int i = 1; i < len2; i++) {
            if(mx > i) p[i] = Math.min(p[2*id-i], mx - i);
            else p[i] = 1;
            for (;str[i+p[i]]==str[i-p[i]];p[i]++);
            if (p[i]+i>mx){
                mx = p[i] + i;
                id = i;
            }
        }
    }
}
