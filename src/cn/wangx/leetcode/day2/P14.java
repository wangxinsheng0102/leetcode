package cn.wangx.leetcode.day2;

/**
 * Create by wangx On 2019/12/27
 * 14.最长公共前缀
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 **/
public class P14 {
    public static void main(String[] args) {
        P14 p14 = new P14();
        String s = p14.longestCommonPrefix(new String[]{"c","acc","ccc"});
        System.out.println(s);
    }

     class MatchStack{
        private Character character;
        private boolean flag = false;
        public Boolean match(Character ch){
            if (ch != this.character){
                flag = true;
                return false;
            }
            if (flag){
                return false;
            }
            return true;
        }

        public void clean(){
            this.character = null;
        }

         public MatchStack(Character character) {
             this.character = character;
         }

         public void setCharacter(Character character) {
             this.character = character;
         }
     }


    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        if (strs.length<=0){
            return ans;
        }
        int len_min = Integer.MAX_VALUE;
        for (String str:strs){
            len_min = Math.min(len_min, str.length());
        }
        for (int i = 0; i < len_min; i++) {
            boolean flag = false;
            MatchStack matchStack = new MatchStack(strs[0].charAt(i));
            for (String str:strs){
                flag = matchStack.match(str.charAt(i));
            }

            if (flag){
                ans += strs[0].charAt(i);
            }else{
                return ans;
            }
        }
        return ans;
    }
}
