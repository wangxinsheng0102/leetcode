package cn.wangx.leetcode.day03;

/**
 * Create by wangx On 2019/12/28
 *24. 两两交换链表中的节点
 *给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 **/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class P24 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        P24 p24 = new P24();
        ListNode listNode1 = p24.swapPairs(listNode);
        while (listNode1!=null){
            System.out.println(listNode1.val);
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while (temp.next != null && temp.next.next != null){
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }
}
