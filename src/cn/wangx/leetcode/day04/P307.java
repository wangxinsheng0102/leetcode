package cn.wangx.leetcode.day04;

/**
 * Create by wangx On 2019/12/29
 * 307. 区域和检索 - 数组可修改
 **/
public class P307 {
    public static void main(String[] args) {
        P307 p307 = new P307();
        int[] nums = new int[]{0,9,5,7,3};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(2,4));
//        int i = numArray.sumRange(0, 2);
//        numArray.update(1,2);
//        int i1 = numArray.sumRange(0, 2);
//        System.out.println(i);
//        System.out.println(i1);
    }
}
class NumArray {
    SegmentTree[] trees = null;
    class SegmentTree{
        int left = -1;
        int right = -1;
        int max = -1;
        int sum = -1;
    }

    void build(int id,int l,int r){
        trees[id].left = l;
        trees[id].right = r;
        if (l == r){
            trees[id].sum = trees[id*2].sum+trees[id*2+1].sum;
            trees[id].max = Math.max(trees[id*2].max, trees[id*2+1].max);
        }else{
            int mid = (l+r)/2;
            build(id*2,l,mid);
            build(id*2+1,mid+1,r);
            trees[id].sum = trees[id*2].sum + trees[id*2+1].sum;
            trees[id].max = Math.max(trees[id*2].max, trees[id*2+1].max);
        }
    }

    void update(int id, int pos,int val){
        if (trees[id].left == trees[id].right){
            trees[id].sum = trees[id].max=val;
        }else {
            int mid = (trees[id].left+trees[id].right)/2;
            if(pos <= mid) update(id*2,pos,val);
            else update(id*2+1,pos,val);
            trees[id].sum = trees[id*2].sum+trees[id*2+1].sum;
            trees[id].max = Math.max(trees[id*2].max,trees[id*2+1].max);
        }
    }

    int query(int id,int l,int r){
        System.out.println("id: "+id+", tree[id].left: "+trees[id].left+", trees[id].right:"+trees[id].right);
        if (trees[id].left == l && trees[id].right == r){
            return trees[id].sum;
        }else {
            int mid = (trees[id].left+trees[id].right)/2;
            if (r <= mid) {
                System.out.println("left");
                return query(id*2,l,r);
            }
            else if (l > mid) {
                System.out.println("right");
                return query(id*2+1,l,r);
            }
            else {
                System.out.println("跨越");
                return query(id*2,l,mid)+query(id*2+1,mid+1,r);
            }
        }
    }

    public NumArray(int[] nums) {
        int len = nums.length;
        if (nums!=null && nums.length > 0){
            trees = new SegmentTree[100000];
            for (int i = 0; i < len*4; i++) {
                trees[i] = new SegmentTree();
            }
            int n = nums.length;
            build(1,1,n);
            for (int i = 0; i < n; i++) {
                update(1,i+1,nums[i]);
            }
        }
    }

    public void update(int i, int val) {
        update(1,i+1,val);
    }

    public int sumRange(int i, int j) {
        try {
            return query(1,i+1,j+1);
        }catch (Exception e){
            return 0;
        }
    }
}
