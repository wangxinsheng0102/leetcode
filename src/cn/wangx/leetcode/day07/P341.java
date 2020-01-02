package cn.wangx.leetcode.day07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class P341 {
    public static void main(String[] args) {
        List<NestedInteger> nestedIntegers = new ArrayList<>();
        NestedIterator i = new NestedIterator(nestedIntegers);
        while (i.hasNext()) System.out.println(i.next());
    }
}

interface NestedInteger {
    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
}
class NestedIterator implements Iterator<Integer> {
    private List<NestedInteger> nestedIntegerList;
    private List<Integer> list = new ArrayList<>();
    private int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedIntegerList = nestedList;
        list = this.integerIterator(nestedIntegerList);
        index = -1;
    }

    @Override
    public Integer next() {
        if (this.hasNext()) return list.get(++index);
        return null;
    }

    @Override
    public boolean hasNext() {
        if (index+1 < list.size()) return true;
        return false;
    }

    public List<Integer> integerIterator(List<NestedInteger> nestedIntegerList){
        ArrayList<Integer> list = new ArrayList<>();
        for (NestedInteger temp:nestedIntegerList){
            if (temp.isInteger()){
                list.add(temp.getInteger());
            }else {
                list.addAll(integerIterator(temp.getList()));
            }
        }
        return list;
    }
}