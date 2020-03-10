package cn.wangx.leetcode.day18;

import cn.wangx.leetcode.TreeNode;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    int dfs(TreeNode root){
        if (root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        ans = Math.max(ans, l + r );
        return Math.max(l,r) + 1;
    }
}
public class P543 {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}
