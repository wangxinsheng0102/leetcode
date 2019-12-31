package cn.wangx.leetcode.day06;

/**
 * Create by wangx On 2019/12/31
 * 98. 验证二叉搜索树
 **/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
public class P98 {
    public static void main(String[] args) {
        P98 p98 = new P98();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(1);
        boolean validBST = p98.isValidBST(treeNode);
        System.out.println(validBST);
    }
    public boolean isValidBST(TreeNode root) {

        return helper(root,null,null);
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper){
        if (node == null) return true;
        int val = node.val;
        if (lower!=null && val <= lower) return false;
        if (upper!=null && val >= upper) return false;

        if (!helper(node.right,val,upper)) return false;
        if (!helper(node.left,lower,val)) return false;
        return true;
    }
}
