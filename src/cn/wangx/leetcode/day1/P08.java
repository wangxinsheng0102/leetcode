package cn.wangx.leetcode.day1;

import com.sun.org.apache.regexp.internal.RE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by wangx On 2019/12/26
 * 8. 字符串转换整数 (atoi)
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *输入: "42"
 * 输出: 42
 *
 **/
public class P08 {

    public static void main(String[] args) {
        P08 p08 = new P08();
        int i = p08.myAtoi("  +123");
        System.out.println(i);
    }

    boolean checkFirstNoneBlankChar(String string){
        int len = string.length();
        for (int i = 0; i < len; i++) {
            if (string.charAt(i)!=' '){
                if (string.charAt(i)!= '-'&& string.charAt(i)!='+'  && (string.charAt(i)<'0' || string.charAt(i)>'9')){
                    return false;
                }
                if (i+1 < len){
                    if (string.charAt(i) == '-' || string.charAt(i) == '+'){
                        if (string.charAt(i+1)<'0'||string.charAt(i+1)>'9'){
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        return true;
    }

    public int myAtoi(String str) {
        str = str.trim();
        int len = str.length();
        if(len==0 || str == null){
            return 0;
        }
        int i=0;
        long result = 0;
        boolean flag = true;
        if(str.charAt(i) == '+'){
            i++;
        }else if(str.charAt(i) == '-'){
            i++;
            flag = false;
        }else if('0'>str.charAt(i)|| str.charAt(i)>'9'){
            return 0;
        }
        int count = 0;
        for(; i<len; i++){
            char a = str.charAt(i);
            if('0'<=a && a<='9'){
                result = result*10 +(a-'0');
                if(result != 0){
                    count++;
                }
                if(count > 10){
                    return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            }else{
                break;
            }
        }
        result = flag ? result : -result;
        if(result > (long)Integer.MAX_VALUE ||
                result < (long)Integer.MIN_VALUE){
            return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int)result;
    }
}
