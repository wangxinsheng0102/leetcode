package cn.wangx.leetcode.day03;

/**
 * Create by wangx On 2019/12/28
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 **/
public class P50 {
    public static void main(String[] args) {
        P50 p50 = new P50();
        double v = p50.myPow(2.00000, 10);
        System.out.println(v);
    }

    public double myPow(double x, int n) {
        double ans = 0;
        ans = Math.pow(x,n);
        return ans;
    }

}
