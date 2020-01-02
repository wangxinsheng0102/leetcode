package cn.wangx.leetcode.day07;

import java.awt.*;

/**
 * Create by wangx On 2020/1/1
 **/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class T2 {
    public static void main(String[] args) {
        T2 t2 = new T2();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        ListNode listNode1 = t2.swapPairs(listNode);
        while (listNode1!=null){
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode helper = helper(head);
        return helper;
    }

    ListNode helper(ListNode head){
        if (head==null) return head;
        ListNode tmp = head;
        ListNode next = head.next;
        head = next;
        next = tmp;
        next.next = head;
        helper(head.next);
        return head;
    }


}
