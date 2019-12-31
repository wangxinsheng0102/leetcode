package cn.wangx.leetcode.day06;

/**
 * 237. 删除链表中的节点
 *
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class P237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
