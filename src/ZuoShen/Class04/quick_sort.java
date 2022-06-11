package ZuoShen.Class04;

import java.util.Arrays;

public class quick_sort {
    public static void main(String[] args) {
        int[] arr = {6,5,1,8,9,8,4,5,1};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    private static void quickSort(int[] arr, int left, int right) {
        if (arr == null || left >= right || arr.length <= 1)
            return;
        int mid = partition(arr, left, right);
        quickSort(arr, left, mid);
        quickSort(arr, mid + 1, right);
    }
    private static int partition(int[] arr, int left, int right) {
        int temp = arr[left];
        while (right > left) {
            // 先判断基准数和后面的数依次比较
            while (temp <= arr[right] && left < right) {
                --right;
            }
            // 当基准数大于了 arr[right]，则填坑
            if (left < right) {
                arr[left] = arr[right];
                ++left;
            }
            // 现在是 arr[right] 需要填坑了
            while (temp >= arr[left] && left < right) {
                ++left;
            }
            if (left < right) {
                arr[right] = arr[left];
                --right;
            }
        }
        arr[left] = temp;
        return left;
    }
    public static void swap(int[] arr, int L, int R) {
        int temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
    }
}