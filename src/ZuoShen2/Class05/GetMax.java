package ZuoShen2.Class05;

public class GetMax {
    //保证参数n不是1就是0的情况下，1->0,0->1
    public static int flip(int n) {
        return n ^ 1;
    }

    //n是非负数，返回1
    //n是负数，返回0
    public static int sign(int n) {
        return flip((n >> 31) & 1);
    }

    public static int getMax1(int a, int b) {
        int c = a - b;  //这个方法有问题，因为a-b可能会溢出
        int scA = sign(c);//a-b为非负，scA为1；a-b为负,scA为0
        int scB = flip(scA);//scA为0,scB为1;scA为1,scB为0
        //scA为0,scB必为1;scA为1,scB必为0
        return a * scA + b * scB;
    }

    //优化方法
    public static int getMax2(int a, int b) {
        int c = a - b;//c依旧可能溢出 一个正的2的32次方-1  -  一个负的2的32次方-1 直接溢出
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int difSab = sa ^ sb; //a和b的符号不一样为1，一样为0 ^为异或
        int sameSab = flip(difSab);//a和b的符号不一样为0，一样为1
        //difSab和difSab互斥  中一个 返回a
        int returnA = difSab * sa + sameSab * sc; //如果a b符号相同，不可能溢出 a-b>=0返回a
        //返回B的条件和返回A的条件互斥
        int returnB = flip(returnA);//如果a和b符号不相同，还得有a是非负 返回a，此时b小于0，一定小于a
        return a * returnA + b * returnB;
    }

    public static void main(String[] args) {
        int a = -16;
        int b = 1;
        System.out.println(getMax1(a, b));
        System.out.println(getMax2(a, b));
        a = 2147483647;
        b = -2147480000;
        System.out.println(getMax1(a, b)); // wrong answer because of overflow
        System.out.println(getMax2(a, b));

    }
}
