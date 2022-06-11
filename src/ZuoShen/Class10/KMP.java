package ZuoShen.Class10;

public class KMP {
    // s.length() >= m.length()
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2); // O(M)
        //O(N)  2N?
        //时间复杂度 i1 (N)  i1-i2(N) 去比较三个分支这两个值的变化  相加为2N
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) { //只有next中0位置上的元素为-1  等价于i2==0
                i1++;
            } else {
                //str2的索引还能往前跳
                i2 = next[i2];
            }
        }
        //i1越界或i2越界了 只要i2越界了 就说明找到了匹配的字符，返回i1-i2也就是字符串的起始位置
        return i2 == str2.length ? i1 - i2 : -1;
    }

    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2; //数组走到的位置
        int cn = 0;
        //时间复杂度 i (M)  i-cn(M) 去比较三个分支这两个值的变化  相加为2M
        while (i < next.length) {
            if (ms[i - 1] == ms[cn]) {
                //cn即代表和i-1比较的位置，也代表当前值
                //++cn，是因为相同了所以长度+1，并且给下一个位置cn保留正确值，i++，是因为这个位置比较完了去比较下一个位置
                next[i++] = ++cn;
            } else if (cn > 0) {
                //如果不相等，cn往前跳
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "ababa";
        System.out.println(getIndexOf(str, match));

    }
}
