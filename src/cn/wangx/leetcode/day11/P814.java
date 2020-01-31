package cn.wangx.leetcode.day11;

import cn.wangx.leetcode.TreeNode;

/**
 * 814. 二叉树剪枝
 */
public class P814 {
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
        public TreeNode pruneTree(TreeNode root) {
            if (root == null) return null;
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
            if (root.val == 0 && root.left == null && root.right == null) return null;
            return root;
        }
    }
}
