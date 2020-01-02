package cn.wangx.leetcode.day08;

/**
 * Create by wangx On 2020/1/2
 * 11. 盛最多水的容器
 **/
public class P11 {
    public static void main(String[] args) {
        P11 p11 = new P11();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        p11.maxArea(height);
    }

    public int maxArea(int[] height) {
        int maxarea = 0, l = 0,r = height.length - 1;
        while (l < r){
            maxarea = Math.max(maxarea, Math.min(height[l],height[r])*(r-l));
            if (height[l] < height[r]){
                l++;
            }else {
                r--;
            }
        }

        return maxarea;
    }
}
