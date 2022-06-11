package LeetCode.easy;

public class first_incorrect_version278 {
    public static void main(String[] args) {

    }
    public boolean isBadVersion(int a ){return  true;}
    public int firstBadVersion(int n) {
        int left=0;
        int right=n;
        //left == right 的时候跳出循环
        while(left < right) {
            int medium = left + ((right - left) >> 1);
            boolean flag = isBadVersion(medium);
            if (flag) {
                //因为有可能mid是恰好为第一个错误的版本
                right = medium;
            }  else{
                left = medium + 1;
            }
        }
        return right;
    }
}
