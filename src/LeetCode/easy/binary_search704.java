package LeetCode.easy;

public class binary_search704 {
    public  static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int medium = (left+right)/2;
        while (left<=right){
            if(target==nums[medium]){
                return medium;
            }
            if(target>nums[medium]){
                left=medium+1;
            }else {
                right=medium-1;
            }
            medium= (left+right)/2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(search(arr,0));
    }

}
