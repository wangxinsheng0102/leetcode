package cn.wangx.nowcode;

import java.util.Stack;

/**
 * Create by wangx On 2019/12/31
 **/
public class TwoStackForOneQueue {

    public static void main(String[] args) {
        TwoStackForOneQueue twoStackForOneQueue = new TwoStackForOneQueue();
        twoStackForOneQueue.push(1);
        twoStackForOneQueue.push(2);
        twoStackForOneQueue.push(3);
        int pop = twoStackForOneQueue.pop();
        int pop1 = twoStackForOneQueue.pop();
        int pop2 = twoStackForOneQueue.pop();
        System.out.println(pop);
        System.out.println(pop1);
        System.out.println(pop2);
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        int res = 0;
        while (stack1.size() > 1){
            Integer pop = stack1.pop();
            stack2.push(pop);
        }
        res = stack1.pop();
        while (stack2.size()>0){
            Integer pop = stack2.pop();
            stack1.push(pop);
        }
        return res;
    }
}
