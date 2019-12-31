package cn.wangx.leetcode.day01;

import java.util.ArrayList;

/**
 * Create by wangx On 2019/12/26
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *输入: 121
 *输出: true
 *
 *
 **/
public class P09 {

    public static void main(String[] args) {
        System.out.println(new P09().isPalindrome(10));
    }


    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (x > 0){
            int s = x % 10;
            x = x / 10;
            arrayList.add(s);
        }
        int len = arrayList.size();
        System.out.println(len);
        Boolean flag = true;
        for (int i = 0; i < len/2; i++) {
            System.out.println(arrayList.get(i)+" ????? "+arrayList.get(len - i - 1));
            if (!arrayList.get(i).equals(arrayList.get(len - i -1))){
                flag = false;
            }
        }
        return flag;
    }
}
