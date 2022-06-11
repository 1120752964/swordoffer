package LeetCode.easy;

public class search_insert_index35 {
    public int searchInsert(int[] nums, int target) {
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
            medium= left + ((right - left) / 2);
        }
        // 分别处理如下四种情况
        // 目标值在数组所有元素之前  [0, -1]
        // 目标值等于数组中某一个元素  return middle;
        // 目标值插入数组中的位置 [left, right]，return  right + 1
        // 目标值在数组所有元素之后的情况 [left, right]， return right + 1
        return right + 1;
    }
}
