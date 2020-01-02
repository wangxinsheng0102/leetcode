package cn.wangx.leetcode.day08;

/**
 * Create by wangx On 2020/1/2
 **/
public class P1037 {
    public static void main(String[] args) {
        P1037 p1037 = new P1037();
        int[][] points = new int[][]{{0,0},{0,2},{2,1}};
        System.out.println(p1037.isBoomerang(points));
    }

    public boolean isBoomerang(int[][] points) {
         int dx = points[1][0] - points[0][0];
         int dy = points[1][1] - points[0][1];
         int ex = points[2][0] - points[0][0];
         int ey = points[2][1] - points[0][1];


        return dx*ey != ex*dy;
    }
}
