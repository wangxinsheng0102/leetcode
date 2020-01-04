package cn.wangx.leetcode.day09;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class P1161 {
    public static void main(String[] args) {
        P1161 p1161 = new P1161();
        p1161.maxLevelSum(new TreeNode(1));
    }

    public int maxLevelSum(TreeNode root) {
        if (root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxSum = root.val;
        int maxLevel = 1;
        int curLevel = 1;
        while (!queue.isEmpty()){
            int s = queue.size();
            int curSum = 0;
            while (s!=0){
                TreeNode front = queue.poll();
                if (front.left!=null){
                    queue.add(front.left);
                }
                if(front.right!=null){
                    queue.add(front.right);
                }
                System.out.println(front.val);
                curSum+=front.val;
                s--;
            }

            if (curSum > maxSum){
                maxSum = curSum;
                maxLevel = curLevel;
            }
            curLevel++;
        }
        return maxLevel;
    }
}
