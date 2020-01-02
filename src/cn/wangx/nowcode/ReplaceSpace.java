package cn.wangx.nowcode;

import java.util.Arrays;

/**
 * Create by wangx On 2019/12/31
 * 替换空格
 **/
public class ReplaceSpace {

    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        String s = replaceSpace.replaceSpace(new StringBuffer("   "));
        System.out.println(s);
    }

    public String replaceSpace(StringBuffer str) {
        StringBuffer ans = new StringBuffer();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' '){
                ans.append("%20");
            }else {
                ans.append(str.charAt(i));
            }
        }

        return ans.toString();
    }
}
