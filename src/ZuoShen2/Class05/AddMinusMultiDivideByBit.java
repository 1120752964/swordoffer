package ZuoShen2.Class05;

public class AddMinusMultiDivideByBit {

    //如果，用户传入的参数，a+b就是溢出的，用户活该。。。
    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b; //无进位相加
            b = (a & b) << 1; //进位信息
            a = sum;
        }
        return sum;
    }
    //获得相反数
    public static int negNum(int n) {
        return add(~n, 1);
    }

    public static int minus(int a, int b) {
        //减法就是a+（-b） 如何获得相反数？  b取反再加1（补码）
        return add(a, negNum(b));
    }

    //如果，用户传入的参数，a*b就是溢出的，用户活该。。。
    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) { //b的最后位置元素是否为1
                res = add(res, a);
            }
            a <<= 1;  //每走一次a左移一位，b右移一位
            b >>>= 1; //a左移 是因为乘法的每一个循环要加的数都左移一位，b右移是为了获得新的末尾
        }
        return res;
    }

    public static boolean isNeg(int n) {
        return n < 0;
    }

    public static int div(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 31; i > -1; i = minus(i, 1)) {
            if ((x >> i) >= y) { //y左移可能会溢出，因此选择x去左移
                                //当然最后运算的时候还是y左移，只是用x去右移来找到i
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new RuntimeException("divisor is 0");
        }
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else if (a == Integer.MIN_VALUE) {
            int res = div(add(a, 1), b);
            return add(res, div(minus(a, multi(res, b)), b));
        } else {
            return div(a, b);
        }
    }

    public static void main(String[] args) {
        int a = (int) (Math.random() * 100000) - 50000;
        int b = (int) (Math.random() * 100000) - 50000;
        System.out.println("a = " + a + ", b = " + b);
        System.out.println(add(a, b));
        System.out.println(a + b);
        System.out.println("=========");
        System.out.println(minus(a, b));
        System.out.println(a - b);
        System.out.println("=========");
        System.out.println(multi(a, b));
        System.out.println(a * b);
        System.out.println("=========");
        System.out.println(divide(a, b));
        System.out.println(a / b);
        System.out.println("=========");

        a = Integer.MIN_VALUE;
        b = 32;
        System.out.println(divide(a, b));
        System.out.println(a / b);

    }
}
