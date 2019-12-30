package cn.wangx.leetcode.day04;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by wangx On 2019/12/29
 **/
public class P165 {
    public static void main(String[] args) {
        P165 p165 = new P165();
        int i = p165.compareVersion("1.0", "1");
        System.out.println(i);
    }

    public int compareVersion(String version1, String version2) {
        int ans = 0;
        String[] version1_s = version1.split("\\.");
        String[] version2_s = version2.split("\\.");
        List<Integer> ver1List = new ArrayList<>();
        List<Integer> ver2List = new ArrayList<>();
        for (String s:version1_s){
            System.out.println(s);
            ver1List.add(Integer.valueOf(s));
        }
        for (String s:version2_s){
            ver2List.add(Integer.valueOf(s));
        }
        int min_len = Math.min(ver1List.size(), ver2List.size());
        for (int i = 0; i < min_len ; i++) {
            System.out.println("v1: "+ver1List.get(i)+", v2:"+ver2List.get(i));
            if (ver1List.get(i) > ver2List.get(i)){
                ans = 1;
                return ans;
            }else if (ver1List.get(i) < ver2List.get(i)){
                ans = -1;
                return ans;
            }
        }
        int count1 = 0;
        int count2 = 0;
        for (int i:ver1List){
            if (i>0){
                count1++;
            }
        }

        for (int i:ver2List){
            if (i>0){
                count2++;
            }
        }

        if (count1 > count2){
            ans = 1;
        }else if (count1 < count2){
            ans = -1;
        }

        return ans;
    }
}
