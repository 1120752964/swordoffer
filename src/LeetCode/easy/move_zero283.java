package LeetCode.easy;

import LeetCode.medium.rotate_array189;

import java.util.Arrays;

public class move_zero283 {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,3,12};
        move_zero283 o = new move_zero283();
        System.out.println(Arrays.toString(arr));
        o.moveZeroes2(arr);
        System.out.println(Arrays.toString(arr));
    }
    //快慢指针 O(n) 可以用于删除指定元素或者移动指定元素
    //搞一个快指针，如果这俩指针在一个地方，那么没有0，如果不在，而且快指针指向的不是0，把快的覆盖给慢的
    //最后快的到达终点的时候，慢指针后面所有元素都是0
    public void moveZeroes2(int[] nums) {
        int fast=0,slow=0;
        while (fast<=nums.length-1){
            if(nums[fast]==0){
                fast++;
            }else {
                nums[slow]=nums[fast];
                slow++;
                fast++;
            }
        }
        while (slow<= nums.length-1){
            nums[slow]=0;
            slow++;
        }
    }

    //暴力解 O(n^2)
    public void moveZeroes(int[] nums) {
        int total=nums.length;
        for (int i = 0; i < total; ) {
            if(nums[i]==0){
                int index=i;
                while (index!=total-1){
                    int temp = nums[index+1];
                    nums[index+1] = nums[index];
                    nums[index] = temp;
                    index++;
                }
                total--;
            }else {
                i++;
            }
        }
    }
}
