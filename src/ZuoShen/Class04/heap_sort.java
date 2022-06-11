package ZuoShen.Class04;

import java.util.Arrays;
import java.util.PriorityQueue;

public class heap_sort {
    public static void main(String[] args) {
        int[] arr = {6,8,4,3,1,2,8,9,10};
        sortedArrDistanceLessK(arr,3);
        System.out.println(Arrays.toString(arr));
    }
    public static void sortedArrDistanceLessK(int[] arr,int k){
        //默认是小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        //index表示堆尾端数字在数组中的脚标
        int index=0;
        for (; index <= k; index++) {
            heap.add(arr[index]);
        }
        //i代表小根堆中要放入数组时对应数组的脚标
        int i=0;
        for(;index<arr.length;i++,index++){
            arr[i] = heap.poll();
            heap.add(arr[index]);
        }
        while (!heap.isEmpty()){
            arr[i++] = heap.poll();
        }
    }


    public static void heapSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        for (int i = 0; i < arr.length; i++) { //O(N)
            heapInsert(arr,i); //O(logN)
        }
        int heapSize = arr.length;
        while (heapSize>0){ //O(N)
            heapify(arr,0,heapSize); //O(logN)
            swap(arr,0,--heapSize); //O(1)
        }

    }


    //将以index为根节点的字树弄成大根堆
    public static void heapify(int[] arr,int index,int heapSize){
        int left = 2*index+1;
        //说明左节点在堆的有效范围中，即有左孩子
        while (left<heapSize){
            //右节点在堆有效范围内且大于左节点时，两节点最大值为右节点，否则为左节点
            int largest = 2*index+2<heapSize&&arr[left]<arr[left+1]?2*index+2:left;
            if(arr[index]<arr[largest]){
                swap(arr,index,largest);
            }else {
                break;
            }
            index=largest;
            left=2*index+1;
        }
    }

    //某个数处在index位置上，判断是否继续向上移动
    public static void heapInsert(int[] arr,int index){
        //如果index到0位置上后因为自己=自己所以跳出循环
        while (arr[index]>arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index=(index-1)/2;
        }
    }
    public static void swap(int[] arr, int L, int R) {
        int temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
    }
}
