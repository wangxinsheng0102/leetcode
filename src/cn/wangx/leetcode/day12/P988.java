package cn.wangx.leetcode.day12;


import cn.wangx.leetcode.TreeNode;

public class P988 {
    StringBuilder tmp = new StringBuilder();
    String ans = "?";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode node){
        if (node == null) return;
        tmp.append((char)('a'+node.val));
        if (node.left == null && node.right == null){
            String tempStr = tmp.reverse().toString();
            ans = tempStr.compareTo(ans) < 0?tempStr:ans;
            tmp.reverse();
        }
        if (node.left != null){
            dfs(node.left);
        }
        if (node.right!=null){
            dfs(node.right);
        }

        tmp.deleteCharAt(tmp.length() - 1);
    }
}
