package cn.wangx.leetcode.day02;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by wangx On 2019/12/27
 *
 * 13. 罗马数字转整数
 *
 **/
public class P13 {

    public static void main(String[] args) {
        P13 p13 = new P13();
        int iii = p13.romanToInt("LVIII");
        System.out.println(iii);
    }

    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int ans = 0;
        char [] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            int temp = ans;
            if (i+1 < len){
                if (chars[i] == 'I' && chars[i+1] == 'V'){
                    ans+=4;
                    i++;
                    continue;
                }else if (chars[i] == 'I' && chars[i+1] == 'X'){
                    ans+=9;
                    i++;
                    continue;
                }else if (chars[i] == 'X' && chars[i+1] == 'L'){
                    ans+=40;
                    i++;
                    continue;
                }else if (chars[i] == 'X' && chars[i+1] == 'C'){
                    ans+=90;
                    i++;
                    continue;
                } else if (chars[i]=='C' && chars[i+1] == 'D'){
                    ans+=400;
                    i++;
                    continue;
                } else if (chars[i] == 'C' && chars[i+1] == 'M'){
                    ans+=900;
                    i++;
                    continue;
                }
            }

            ans+=map.get(chars[i]);

        }

        return ans;
    }
}
