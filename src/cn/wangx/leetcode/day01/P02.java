package cn.wangx.leetcode.day01;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by wangx On 2019/12/26
 **/
public class P02 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        ListNode temp = null;
        temp = l2;
        for (int i = 0; i < 9; i++) {
            temp.next = new ListNode(9);
            temp = temp.next;
        }
        Solution solution = new Solution();
        ListNode listNode = solution.addTwoNumbers(l1, l2);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = null;
        int count = 0;
        int sum1 = 0;
        int sum2 = 0;
        List<Integer> num1 = new ArrayList<>();
        List<Integer> num2 = new ArrayList<>();
        while (l1!=null){
            temp = l1;
            l1 = l1.next;
            sum1 += Math.pow(10,count) * temp.val;
            num1.add(temp.val);
            count++;
        }
        count = 0;
        while (l2!=null){
            temp = l2;
            l2 = l2.next;
            sum2 += Math.pow(10,count) * temp.val;
            num2.add(temp.val);
            count++;
        }
        int n = Math.max(num1.size(), num2.size());
        int[] res = new int[100000];
        for (int i=0;i<100000;i++){
            res[i] = 0;
        }
        for (int i = 0; i < n ; i++) {
            if (num1.size() <= i){
               res[i] += num2.get(i);
            }else if(num2.size() <= i){
                res[i] += num1.get(i);
            }else {
                res[i] += num1.get(i) + num2.get(i);
            }
            if (res[i] >= 10){
                res[i+1] += res[i] / 10;
//                System.out.println("res[i]"+res[i]+" ,"+res[i+1]);
                res[i] = res[i] % 10;
            }
        }
        ListNode listNode = null;
        for (int i=0;i < n+1;i++){
            if (i==0){
                listNode = new ListNode(res[i]);
                temp = listNode;
            }else {
                if (i == n && res[i] <= 0){
                    continue;
                }
                listNode.next = new ListNode(res[i]);
                listNode = listNode.next;
            }
        }
        return temp;
    }
}
