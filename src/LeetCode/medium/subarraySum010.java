package LeetCode.medium;

import java.util.Arrays;

public class subarraySum010 {
    public static void main(String[] args) {
        System.out.println( subarraySum(new int[]{1,-1,0},0));
        String a = "ada";
        
    }

    public static int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int sum=0;int result = 0;
        for(int i=0;i<n;i++){
            sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                if(sum==k){
                    result++;
                }
            }
        }
        return result;
    }
    public static int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
