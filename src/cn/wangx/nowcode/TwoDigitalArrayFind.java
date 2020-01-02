package cn.wangx.nowcode;

/**
 * Create by wangx On 2019/12/31
 * 二维数组查找
 * 在一个二维数组中（每个一维数组的长度相同）
 * ，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 **/
public class TwoDigitalArrayFind {

    public static void main(String[] args) {
        int[][] array = new int[][]{{1}};
        int target = 1;
        TwoDigitalArrayFind twoDigitalArrayFind = new TwoDigitalArrayFind();
        boolean find = twoDigitalArrayFind.Find(target, array);
        System.out.println(find);
    }


    public boolean Find(int target, int [][] array) {
        System.out.println(array.length);
        if (array.length == 0 || array[0].length == 0){
            return false;
        }
        int m = array.length,n = array[0].length;
        for (int i = m-1; i >= 0 ; i--) {
            if (array[i][0] <= target){
                for (int j = 0; j < n ; j++) {
                    if (array[i][j] == target){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
