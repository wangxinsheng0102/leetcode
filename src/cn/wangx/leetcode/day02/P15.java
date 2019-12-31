package cn.wangx.leetcode.day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create by wangx On 2019/12/27
 * 15. 三数之和
 **/
public class P15 {
    public static void main(String[] args) {
        P15 p15 = new P15();
        int[] ints = new int[6];
        ints[0] = -1;
        ints[1] = 0;
        ints[2] = 1;
        ints[3] = 2;
        ints[4] = -1;
        ints[5] = -4;
        p15.threeSum(ints);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (nums == null || nums.length < 3){
            return ans;
        }
        //从小到大排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length ; i++) {
            //如果这个数字大于0，那么之后的结果就都大于0了
            if (nums[i]>0) break;
            if (i>0 && nums[i] == nums[i-1]) continue;
            int l = i+1;
            int r = len - 1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while (l < r && nums[l] == nums[l+1]) l++;
                    while (l < r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                }
                else if (sum < 0){
                    l++;
                }
                else if (sum > 0){
                    r--;
                }
            }
        }
        return ans;
    }
}
