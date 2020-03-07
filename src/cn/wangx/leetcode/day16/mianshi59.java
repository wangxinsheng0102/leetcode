package cn.wangx.leetcode.day16;

import java.util.*;

class MaxQueue1 {
    Queue<Integer> queue = new LinkedList<>();
    Queue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    public MaxQueue1() {

    }

    public int max_value() {
        if (maxQueue.size() == 0){
            return  -1;
        }else{
            int max_val = maxQueue.poll();
            maxQueue.add(max_val);
            return max_val;
        }
    }

    public void push_back(int value) {
        queue.add(value);
        maxQueue.add(value);
    }

    public int pop_front() {
        if (queue.size() == 0){
            return -1;
        }else{
            int ret = queue.poll();
            maxQueue.remove(ret);
            return ret;
        }
    }
}

class MaxQueue {
    //最大的节点
    private Node max;
    //根节点
    private Node root;
    //尾结点
    private Node tail;
    class Node{
        int val;
        Node next=null;
        public Node(int val){this.val=val;}
    }

    public MaxQueue() {
        this.root=new Node(-1);
        root.next=null;
        this.max=root;
        this.tail=root;
    }

    public int max_value() {
        //队列为空
        if(root==tail)return -1;
        return max.val;

    }

    public void push_back(int value) {
        //生成临时节点
        Node tmp=new Node(value);
        //链接进原来的队列
        tail.next=tmp;
        //将尾结点后移
        tail=tmp;
        //存储最大节点的位置和值
        if(max==root||max.val<=value)max=tmp;
    }

    public int pop_front() {
        if(tail==root)return -1;
        //root为哨兵
        root=root.next;//root并不代表实际节点
        if(root==max){//最大值要出去了
            Node head=root.next;//head-tail才代表实际的队列
            max=head;
            while(head!=null){
                max=max.val<=head.val?head:max;
                head=head.next;
            }
        }
        max=(max==null)?root:max;

        return root.val;
    }
}
public class mianshi59 {
    public static void main(String[] args) {
            MaxQueue obj = new MaxQueue();
         int param_1 = obj.max_value();
         obj.push_back(1);
         obj.push_back(2);
         int param_2 = obj.max_value();
         int param_3 = obj.pop_front();
        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(param_3);
    }
}
