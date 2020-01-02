package cn.wangx.nowcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by wangx On 2019/12/31
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 **/
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}

public class FromEndToStart {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ansList = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        ListNode temp = listNode;
        while (temp!=null){
            tempList.add(temp.val);
            temp = temp.next;
        }
        for (int i = tempList.size()-1; i >= 0 ; i--) {
            ansList.add(tempList.get(i));
        }
        return ansList;
    }
}
