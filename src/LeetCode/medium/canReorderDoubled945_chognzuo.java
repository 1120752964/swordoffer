package LeetCode.medium;

import java.util.*;

public class canReorderDoubled945_chognzuo {
    public static void main(String[] args) {
        System.out.println(canReorderDoubled(new int[]{4,-2,2,-4}));
    }

    public static boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        //给数组放到map里  统计有多少种数字  每种数字有多少个
        for (int j : arr) {
           map.put(j,map.getOrDefault(j,0)+1);
        }
        //一共有多少种 全都放到数组里
        ArrayList<Integer> arrayList = new ArrayList<>(map.keySet());
        //对数组进行排序 排序规则为绝对值从小到大  因为-2*2 为-4 所以先遍历-2，2*2=4,所以先遍历2
        arrayList.sort((a, b) -> Math.abs(a) - Math.abs(b));
        //遍历每种数字
        for (Integer integer : arrayList) {
            //绝对值从小到大的遍历种类， 如果2倍的integer数量小于integer数量，那么一定不满足条件
            if(map.getOrDefault(2*integer,0)<map.get(integer)){
                return false;
            }
            //因为integer只会遍历到一次  它是最小的  2*integer永远也不会超过integer大小 有可能相等
            //因此只需要设置2*integer 不用管integer
            //这里一定要用getOrDefault是因为上面是Default情况且map.get(integer)恰好是0的时候会走下来。。
            map.put(2*integer,map.getOrDefault(2*integer,0)-map.get(integer));
        }
        return true;
    }
}
