package cn.wangx.leetcode.day10;

public class P1025 {
    public static void main(String[] args) {
        P1025 p1025 = new P1025();
        boolean b = p1025.divisorGame(2);
        System.out.println(b);
    }

    public boolean divisorGame(int N) {
        return (N&1) ==0;
    }

    public int gcd(int a,int b){
        return b==0?a:gcd(b, a%b);
    }
}
