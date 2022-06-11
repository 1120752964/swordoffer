package LeetCode.medium;

import LeetCode.easy.move_zero283;

import java.util.Arrays;

public class two_number_sum2_167 {

    public static void main(String[] args) {
        int[] arr = new int[]{-1,0};
        two_number_sum2_167 o = new two_number_sum2_167();
        System.out.println(Arrays.toString(arr));
        arr= o.twoSum2(arr,-1);
        System.out.println(Arrays.toString(arr));
    }
    //双指针解法  因为两个和的组合只出现一次且是非递减数组，因此可以左边从头开始，右边从尾开始
    //当小于target的时候左指针走，大于的时候右指针走
    public int[] twoSum2(int[] numbers, int target) {
       int left=0;int right=numbers.length-1;
       while (left<right){
           if(numbers[left]+numbers[right]==target){
               return new int[]{left+1,right+1};
           }else if(numbers[left]+numbers[right]>target){
               right--;
           }else {
               left++;
           }
       }
        return new int[]{-1,-1};
    }
    //暴力解法
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int j=i+1;
            while (j<numbers.length&&(numbers[j]+numbers[i]<=target)){
                if(numbers[j]+numbers[i]==target){
                    result[0]=i+1;
                    result[1]=j+1;
                    return result;
                }else {
                    j++;
                }
            }
        }
        return result;
    }

}
