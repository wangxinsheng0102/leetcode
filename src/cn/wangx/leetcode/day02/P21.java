package cn.wangx.leetcode.day02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Create by wangx On 2019/12/27
 **/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class P21 {

    public static void main(String[] args) {
        P21 p21 = new P21();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        p21.mergeTwoLists(l1,l2);
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = null;
        List<Integer> list = new ArrayList<>();
        while (l1!=null){
            ListNode temp = l1;
            list.add(l1.val);
            l1 = l1.next;
        }
        while (l2!=null){
            ListNode temp = l2;
            list.add(l2.val);
            l2 = l2.next;
        }

        Collections.sort(list);
        ListNode temp = null;
        for (int i = 0; i < list.size() ; i++) {
            if (i == 0){
                ans = new ListNode(list.get(i));
                temp = ans;
                continue;
            }

            temp.next = new ListNode(list.get(i));
            temp = temp.next;
        }

        return  ans;
    }
}
