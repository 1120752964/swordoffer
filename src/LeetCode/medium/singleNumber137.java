package LeetCode.medium;

public class singleNumber137 {
    public static void main(String[] args) {
        int[] nums = {2,2,3,2};
        int [] a = {}   ;
        System.out.println(singleNumber2(nums));;
    }
    public static int singleNumber(int[] nums) {
        int result=0;
        int count=0;
        int i=1;
        for(int j=0;j<32;j++){
            for(int n:nums){
                if((i&n)!=0){
                    count++;
                }
            }
            result|=((count%3)<<j);
            count=0;
            i=i<<1;
        }
        return result;
    }
    public static int singleNumber2(int[] nums) {
        int first = 0;
        int second = 0;
        for (int n:nums){
            first= (first^n)& (~second);
            second = (second^n)&(~first);
        }
        return first;
    }
}
