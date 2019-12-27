package cn.wangx.leetcode.day2;

import java.util.Stack;

/**
 * Create by wangx On 2019/12/27
 * 20. 有效的括号
 **/
public class P20 {

    public static void main(String[] args) {
        P20 p20 = new P20();
        boolean valid = p20.isValid("[]");
        System.out.println(valid);
    }


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push('$');
        if (s.length() < 2){
            if (s.length() == 0){
                return true;
            }
            return false;
        }
        char[] chars = s.toCharArray();
        for (Character ch:chars){
            if (ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            System.out.println(stack.size());
            if (ch == ')' || ch == '}' || ch == ']'){
                if (stack.size() > 0){
                    Character top = stack.pop();
                    if (ch == ')' && top != '('){
                        return false;
                    }else if (ch == '}' && top!='{'){
                        return false;
                    }else if (ch==']' && top!='['){
                        return false;
                    }else if (top == '$'){
                        return false;
                    }
                }
            }
        }
        stack.pop();
        return stack.isEmpty();
    }


}
