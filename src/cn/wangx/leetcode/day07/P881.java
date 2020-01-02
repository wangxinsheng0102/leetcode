package cn.wangx.leetcode.day07;

import java.util.*;

/**
 * Create by wangx On 2020/1/1
 * 881. 救生艇
 * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 *
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 *
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/boats-to-save-people
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class P881 {
    public static void main(String[] args) {
        P881 p881 = new P881();
        int[] people = new int[]{5,1,4,2};
        int limit = 6;
        int i = p881.numRescueBoats(people, limit);
        System.out.println(i);
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0,j = people.length - 1;
        int ans = 0;
        while (i <= j){
            ans++;
            if (people[i]+people[j] <= limit){
                i++;
            }
            j--;
        }
        return ans;
    }
}
