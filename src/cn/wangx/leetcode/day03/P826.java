package cn.wangx.leetcode.day03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Create by wangx On 2019/12/28
 * 826. 安排工作以达到最大收益
 *有一些工作：difficulty[i] 表示第i个工作的难度，profit[i]表示第i个工作的收益。
 *
 * 现在我们有一些工人。worker[i]是第i个工人的能力，即该工人只能完成难度小于等于worker[i]的工作。
 *
 * 每一个工人都最多只能安排一个工作，但是一个工作可以完成多次。
 *
 * 举个例子，如果3个工人都尝试完成一份报酬为1的同样工作，那么总收益为 $3。如果一个工人不能完成任何工作，他的收益为 $0 。
 *
 * 我们能得到的最大收益是多少？
 *
 * 输入: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
 * 输出: 100
 * 解释: 工人被分配的工作难度是 [4,4,6,6] ，分别获得 [20,20,30,30] 的收益。
 *
 **/
public class P826 {

    public static void main(String[] args) {
        int[] difficult = new int[]{13,37,58};
        //[13,37,58]
        //[4,90,96]
        //[34,73,45]
        int[] profit = new int[]{4,90,96};
        int[] work = new int[]{34,73,45};
        P826 p826 = new P826();
        int i = p826.maxProfitAssignment(difficult, profit, work);
        System.out.println(i);
    }


    class Work implements Comparable<Work>{
        private int difficult;
        private int profit;
        private int avg;
        int flag = 0;

        public Work(int difficult, int profit, int avg) {
            this.difficult = difficult;
            this.profit = profit;
            this.avg = avg;
        }

        public int getDifficult() {
            return difficult;
        }

        public void setDifficult(int difficult) {
            this.difficult = difficult;
        }

        public int getProfit() {
            return profit;
        }

        public void setProfit(int profit) {
            this.profit = profit;
        }

        public int getAvg() {
            return avg;
        }

        public void setAvg(int avg) {
            this.avg = avg;
        }

        @Override
        public int compareTo(Work work) {
            int res = 0;
            res = work.profit - this.profit;
            if (res == 0){
                res = work.difficult - this.difficult;
            }
            return res;
        }

        @Override
        public String toString() {
            return "Work{" +
                    "difficult=" + difficult +
                    ", profit=" + profit +
                    ", avg=" + avg +
                    '}';
        }
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int ans = 0;
        List<Work> workList = new ArrayList<>();
        int len = difficulty.length;
        for (int i = 0; i < len ; i++) {
            Work work = new Work(difficulty[i],profit[i],profit[i]/difficulty[i]);
            workList.add(work);
        }
        Collections.sort(workList);

        int n = worker.length;



        for (int i = 0; i < n ; i++) {
            for (Work work:workList){
                if (worker[i] >= work.getDifficult()){
                        ans+=work.getProfit();
                        break;
                }
            }
        }
        return ans;
    }



}
