package LeetCode.easy;

public class ordered_array_square977 {
    //从中间往两边走  还有一种从两边往中间走比较简单
    public  int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left=0;
        //找到分界线
        for (int i = 0; i < n; i++) {
            if(nums[i]<0){
                left=i;
            }else {
                break;
            }
        }
        int[] arr = new int[n];
        int index=0;int right=left+1;
        while (left>=0||right<n) {
            //前两个情况判断越界之后就往另一个方向走完
            if(left<0){
                arr[index]=nums[right]*nums[right];
                ++right;
            }else if (right==n){
                arr[index]=nums[left]*nums[left];
                --left;
            }else if (nums[left]*nums[left]<nums[right]*nums[right]){
                arr[index]=nums[left]*nums[left];
                --left;
            }else {
                arr[index]=nums[right]*nums[right];
                ++right;
            }
            index++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-4,-4,-3};
        ordered_array_square977 o = new ordered_array_square977();
        arr = o.sortedSquares(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
