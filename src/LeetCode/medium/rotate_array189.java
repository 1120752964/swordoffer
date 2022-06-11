package LeetCode.medium;

import java.util.Arrays;

public class rotate_array189 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        rotate_array189 o = new rotate_array189();
        System.out.println(Arrays.toString(arr));
        o.rotate4(arr,3);
    }
    //也类似于交换位置
    //右移
    //先整体翻转 1234567->7654321 然后翻转[0,k%length-1] 5674321，然后翻转剩下的5671234
    //左移
    //先各自局部翻转1234567->3217654 然后整体翻转4567123
    //这里题目要求右移  因此先整体 后局部  不使用额外空间复杂度
    public void rotate4(int[] nums, int k) {
        k=k% nums.length;
        reverse(nums,0, nums.length-1);
        reverse(nums,0, k-1);
        reverse(nums,k, nums.length-1);
    }
    public void reverse(int[] nums,int left,int right){
        while (left<right){
            int temp = nums[right];
            nums[right]=nums[left];
            nums[left]=temp;
            left+=1;
            right-=1;
        }
    }

    //不使用额外空间复杂度   双指针  走一圈 起始位置往右走一个 直到走完所有元素
    //搞了这么久主要是coding太差了 dowhile的使用很重要
    public void rotate3(int[] nums, int k) {
        int count = 0;// 记录交换位置的次数，n个同学一共需要换n次
        int n=nums.length;
        k=k%n;
        for (int start = 0; count < n; start++) {
            int cur = start;// 从0位置开始换位子
            int pre = nums[start];
            do{
                int next = (cur+k)%n;
                int temp = nums[next];// 来到角落...
                nums[next] = pre;
                pre=temp;
                cur=next;
                count++;
            }while (start!=cur);// 循环暂停，回到起始位置，角落无人
        }
    }

    //需要额外的空间复杂度O(n)  时间也是O(n)
    public void rotate2(int[] nums, int k) {
        int n= nums.length;
        int[] arr = new int[n];
        int temp=0;
        for (int i = 0; i < n; i++) {
            temp=(i+k)%n;
            arr[temp] = nums[i];
        }
        //（原数组， 原数组的开始位置， 目标数组， 目标数组的开始位置， 拷贝个数）
        System.arraycopy(arr, 0, nums, 0, arr.length);
    }

    //超时  明天总结剩下的正确三种  O(k*n)的时间复杂度
    public void rotate1(int[] nums, int k) {
        int temp = 0;//中间值
       while (k!=0){
           k--;
           temp = nums[nums.length-1];
           for (int i = nums.length-1; i > 0; i--) {
               nums[i] = nums[i-1];
           }
           nums[0]=temp;
       }
    }
}
