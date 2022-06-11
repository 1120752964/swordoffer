package ZuoShen2.Class04;

import java.util.LinkedList;

public class SlidingWindowMaxArray {
    // w是窗口的大小
    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        // 存的是脚标 值  大->小
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) { //窗口（刚才讲的）的R
            //i -> arr[i]
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) { //i-w 过期的脚标
                qmax.pollFirst();
            }
            if (i >= w - 1) { //窗口形成了
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
    // for test
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 5, 4, 3, 3, 6, 7 };
        int w = 3;
        printArray(getMaxWindow(arr, w));

    }
}
