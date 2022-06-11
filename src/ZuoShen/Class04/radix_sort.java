package ZuoShen.Class04;

import java.util.Arrays;

public class radix_sort {
    public static void main(String[] args) {
        int[] arr = {6,900,4000,32,11,312,328,91,10};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void radixSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        radixSort(arr,0,arr.length-1,maxbits(arr));
    }

    //桶排序
    public static void radixSort(int[] arr,int L,int R,int digit){
        final int radix = 10;//桶是0-9，这个永远不会变，十进制只有10个数
        int i = 0,j = 0;
        int[] bucket = new int[R-L+1];//有多少个数就创建多少的辅助空间
        for(int d=0;d<digit;d++){//有多少位就要进出几次
            int[] count = new int[radix];//代表，该位上的数字数量的累加和  length=10
            for(i=L;i<=R;i++){
                j=getDigit(arr[i],d);  //返回i元素第d位上的数字
                count[j]++;  //记录d位上位j的元素数量   等价于初始的桶排序版本
            }
            for ( i = 1; i < radix; i++) {
                count[i] = count[i]+count[i-1]; //优化后，计算count累加和
            }
            for(i=R;i>=L;i--){          //相当于一次出桶操作
                j=getDigit(arr[i],d);
                bucket[count[j]-1] = arr[i]; //从右往左开始，判断该元素d位置数字，将其放到辅助数组中
                count[j]--;                  //位置为count数组中，以该元素d位置数字为脚标的元素-1
            }
            for(i=L,j=0;i<=R;i++,j++){
                arr[i] = bucket[j];  //将辅助数组赋值到arr中对应位置上
            }
        }
    }
    //用于返回第d位上的数字
    public static int getDigit(int x,int d){
        return ((x / ((int) Math.pow(10,d)))%10); //pow() 方法用于返回第一个参数的第二个参数次方。
    }
    //这个数组中最大值有多少位
    public static int maxbits(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max,arr[i]);
        }
        int res = 0;
        while (max!=0){
            max/= 10;
            res++;
        }
        return res;
    }
}
