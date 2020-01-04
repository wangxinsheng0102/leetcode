package cn.wangx.leetcode.day09;

import java.util.ArrayList;
import java.util.List;

public class P442 {

    public static void main(String[] args) {
        int[] nums = new int[]{10,2,5,10,9,1,1,4,3,7};
        P442 p442 = new P442();
        List<Integer> duplicates = p442.findDuplicates(nums);
        duplicates.forEach(System.out::println);
    }


    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ansList = new ArrayList<>();
        for (int n:nums){
            n = Math.abs(n);
            if (nums[n-1] < 0){
                ansList.add(n);
            }else{
                nums[n-1] = - nums[n-1];
            }
        }
        return ansList;
    }
}
