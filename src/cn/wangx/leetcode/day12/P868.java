package cn.wangx.leetcode.day12;

import java.util.ArrayList;
import java.util.List;

public class P868 {
    public static void main(String[] args) {
        P868 p868 = new P868();
        int i = p868.binaryGap(5);
        System.out.println(i);
    }

    //        public int binaryGap(int N) {
//            String binary = Integer.toBinaryString(N);
//            System.out.println(binary);
//            char[] chars = binary.toCharArray();
//            int len = chars.length;
//            int ans = 0;
//            for (int i = 0; i < len ; i++) {
//                if (chars[i] == '1'){
//                    for (int j = i+1; j < len; j++) {
//                        if (chars[j] == '1'){
//                            ans = Math.max(j-i, ans);
//                            break;
//                        }
//                    }
//                }
//            }
//            return ans;
//        }
    public int binaryGap(int N) {
        int ans = 0;
        List<Integer> indexList = new ArrayList<>();
        String binary = Integer.toBinaryString(N);
        System.out.println(binary);
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                indexList.add(i);
            }
        }
        for (int i = 0; i < indexList.size() - 1; i++) {
            ans = Math.max(ans, indexList.get(i + 1) - indexList.get(i));
        }
        return ans;
    }
}
