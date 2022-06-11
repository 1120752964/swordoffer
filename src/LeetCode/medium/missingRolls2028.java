package LeetCode.medium;

import java.util.Arrays;

public class missingRolls2028 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(missingRolls(new int[]{4,5,6,2,3,6,5,4,6,4,5,1,6,3,1,4,5,5,3,2,3,5,3,2,1,5,4,3,5,1,5},4,40)));;
    }
    public static int[] missingRolls(int[] rolls, int mean, int n) {
        //数组的总数应该是多少
        int sumArr = 0;
        for(int i=0;i<rolls.length;i++){
            sumArr+=rolls[i];
        }
        //真正的总数
        int sum = (n+rolls.length)*mean;
        //返回的数组的总数应该是多少
        int sub = sum-sumArr;
        System.out.println(sub);
        System.out.println(n);
        //平均数
        if(sub>6*n||sub< n){
            return new int[0];
        }
        //创建数组
        int[] arr = new int[n];
        int x=sub/n;  //平均值
        int y=sub%n; //需要匀到其余的数上的值
        for(int i=0;i<n;i++){
            arr[i]=x;
        }
        int index=0;
        while (y!=0){
            arr[index]+=1;
            index=(index+1)%n;
            y--;
        }
        return arr;
    }
}
