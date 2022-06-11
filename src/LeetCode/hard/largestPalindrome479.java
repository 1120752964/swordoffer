package LeetCode.hard;

public class largestPalindrome479 {
    public static void main(String[] args) {
        System.out.println(largestPalindrome(3));
    }
    public static int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int upper = (int) Math.pow(10, n) - 1;
        int ans = 0;
        for (int left = upper; ans == 0; --left) { // 枚举回文数的左半部分 从999--
            long p = left;
            for (int x = left; x > 0; x /= 10) {
                p = p * 10 + x % 10; // 翻转左半部分到其自身末尾，构造回文数 p 例如987 -> 9870+7 ->98770+8
                // 98778->987780+9 得到完整的回文987789 这里有贪心 因为偶数一定比奇数长度大
            }
            for (long x = upper; x * x >= p; --x) {//x>根号p 因为是从大遍历下来的  如果小于的话肯定已经遍历过了
                if (p % x == 0) { // x 是 p 的因子 p分解成 x和p/x x从大到小 p/x从小到大 相等的时候结束
                    ans = (int) (p % 1337);
                    break;
                }
            }
        }
        return ans;
    }
    public static int largestPalindrome1(int n) {
        int a = 1;
        while(n!=0){
            a*=10;n--;
        }
        int max=Integer.MIN_VALUE;
        a=a-1;
        int b=a;
        for(int i=a;i>=0;i--){
            for(int j=b;j>=0;j--){
                if(isHuiWen(i*j+"")){
                    max=Math.max(max,i*j);
                }
            }
        }
        System.out.println(max);
        return max%1337;
    }

    public static boolean isHuiWen(String s){
        return s.equals(new StringBuffer(s).reverse().toString());
    }
}
