package LeetCode.easy;

public class hasAlternatingBits693 {
    public static void main(String[] args) {
//        System.out.println(hasAlternatingBits(4));
//        binaryToDecimal(4);
//        binaryToDecimal2(4);
        binaryToDecimal3(4);
    }
    //通过位运算
    public static void binaryToDecimal3(int n){
        for (int i = 31; i >=0 ; i--) {
            System.out.print(n>>>i&1);
        }
    }
        //字符串转二进制  先搞出来一位  放在前面  然后除以2  循环
    public static void binaryToDecimal2(int n){
        String str = "";
        while(n!=0){
            str = n%2+str;
            n = n/2;
        }
        System.out.println(str);
    }
    public static void binaryToDecimal(int n){
        int t = 0;  //用来记录位数
        int bin = 0; //用来记录最后的二进制数
        int r = 0;  //用来存储余数
        while(n != 0){
            r = n % 2;
            n = n / 2;
            //用数字来记录
            bin += r * Math.pow(10,t);
            t++;
        }
        System.out.println(bin);
    }
    public static boolean hasAlternatingBits(int n) {
//        String s = Integer.toBinaryString(n);
//        System.out.println(s);
        int pre=n%2==0?1:0;
        int cur=0;
//        StringBuilder a = new StringBuilder();
        while (n!=0){
            cur = n%2;
//            a.insert(0, cur);
            if(cur==pre){
                return false;
            }
            pre=cur;
            n/=2;
        }
//        System.out.println(a);
        return true;
    }
}
