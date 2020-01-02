package cn.wangx.leetcode.day07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Create by wangx On 2020/1/1
 **/
public class M1 {

    public static void main(String[] args) {
        M1 m1 = new M1();
        int[] arr = new int[]{1,2,3,4,5};
        int k = 4;
        int x = 3;
        m1.findClosestElements(arr,k,x);
    }

    class Answer implements Comparable<Answer>{
        int minus;
        int val;

        @Override
        public int compareTo(Answer o) {
            return this.minus - o.minus;
        }

        public Answer(int minus, int val) {
            this.minus = minus;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Answer{" +
                    "minus=" + minus +
                    ", val=" + val +
                    '}';
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ansList = new ArrayList<>();
        List<Answer> tmpList = new ArrayList<>();
        for (int s:arr){
            tmpList.add(new Answer(Math.abs(s - x),s));
        }
        Collections.sort(tmpList);
        for (Answer answer:tmpList){
            System.out.println(answer);
        }
        for (int i = 0; i < k ; i++) {
            System.out.println(tmpList.get(i).val);
            ansList.add(tmpList.get(i).val);
        }
        Collections.sort(ansList);
        return ansList;
    }
}
