package cn.wangx.leetcode.day10;

import java.util.*;

public class P216 {


    public static void main(String[] args) {
        P216 p216 = new P216();
        List<List<Integer>> lists = p216.combinationSum3(3, 7);
        Iterator iterator = lists.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k,n,1);
        return ans;
    }

    private void dfs(int k,int n,int start){
        if (k<0 || n<0) return;
        if (k == 0 && n == 0) {
            if (!path.isEmpty()){
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = start; i <= 9 ; i++) {
            path.push(i);
            dfs(k-1, n - i, ++start);
            path.pop();
        }
    }
}
