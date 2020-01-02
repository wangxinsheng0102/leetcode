package cn.wangx.leetcode.day07;

/**
 * Create by wangx On 2020/1/1
 * 递归反转字符串
 **/
public class T1 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        char[] s = new char[]{'h','e','l','l'};
        t1.reverseString(s);
    }

    public void reverseString(char[] s) {
        s = helper(s.length - 1, s.length - 1, s);
        for (char ch:s){
            System.out.println(ch);
        }
    }

    public char[] helper(int len,int target,char[] s){
        if (len <= 0){
            return s;
        }
        int l = len - target;
        int r = target;
        char tmp = s[r];
        s[r] = s[l];
        s[l] = tmp;
        System.out.println(l+" "+r+" is 2 ? "+len%2);
        if (l == r && (len+1) % 2 !=0) {
            return s;
        }else if (l == r-1){
            return s;
        }
        if (target == 0) return s;
        helper(len,--target,s);
        return s;
    }
}
