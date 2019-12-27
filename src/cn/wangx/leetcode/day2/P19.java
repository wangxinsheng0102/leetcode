package cn.wangx.leetcode.day2;

/**
 * Create by wangx On 2019/12/27
 * 19. 删除链表的倒数第N个节点
 **/
public class P19 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(4);
//        l1.next.next.next.next = new ListNode(5);
        P19 p19 = new P19();
        ListNode listNode = p19.removeNthFromEnd2(l1, 2);
        while (listNode!=null){
            System.out.print(listNode.val+"  -->");
            listNode = listNode.next;
        }
    }

    /**
     * 暴力两次遍历
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode t = head;
        ListNode temp = head;
        while (temp!=null){
            temp = temp.next;
            count++;
        }
        if (count == 1){
            return null;
        }
        int index = 0;
        temp = head;

        int len = count - n - 1;
        for (int i = 0; i < len ; i++) {
            temp = temp.next;
        }

        if (len == count - 2){
            System.out.println(temp.val);
            temp.next = null;
        }else if (len < 0){
            head = temp.next;
        }
        else {
            temp.next = temp.next.next;
        }

        return head;
    }

    /**
     * 一次遍历
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        //设置哨兵结点
        ListNode content = new ListNode(0);
        content.next = head;
        ListNode l1 = content;
        ListNode l2 = content;
        //l1先向前走n+1步
        while (n!=0){
            l1 = l1.next;
            n--;
        }
        //l1,l2同时开始前进,当l1到达尾部结束
        while (l1.next!=null){
            l1 = l1.next;
            l2 = l2.next;
        }
        //此时l2就到达了指定位置
//        System.out.println(l2.val);
//        System.out.println(l2.next.val);
//        System.out.println(l2.next.next.val);
        l2.next = l2.next.next;
        return  content.next;
    }
}
