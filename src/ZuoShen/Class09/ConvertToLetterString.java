package ZuoShen.Class09;

public class ConvertToLetterString {
    public static int number(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        return process(str.toCharArray(), 0);
    }

    //i之前的位置，如何转化已经做过决定了
    //i... 有多少种转化的结果
    public static int process(char[] chs, int i) {
        if (i == chs.length) { //因为前面的选择都是合理的  没有两个合一个的情况  所以长度一样
            return 1;
        }
        if (chs[i] == '0') { //虽然是之前有效，但也没意义  0没有对应的 后续的情况G了 整体就只有0种有效的
            return 0;
        }
        if (chs[i] == '1') {
            int res = process(chs, i + 1); //i自己作为单独的部分（不合体），后续有多少种方法
            if (i + 1 < chs.length) {
                res += process(chs, i + 2);//i和i+1作为单独的部分（合体了）,后续有多少种方法
            }
            return res;
        }
        if (chs[i] == '2') {
            int res = process(chs, i + 1);//i自己作为单独的部分（不合体），后续有多少种方法
            //i和i+1作为单独的部分（合体了）并且没有超过26,后续有多少种方法
            if (i + 1 < chs.length && (chs[i + 1] >= '0' && chs[i + 1] <= '6')) {
                res += process(chs, i + 2);
            }
            return res;
        }
        //chs[i] == '3' ~ '9'  因为没有多余的情况  所以不用相加
        return process(chs, i + 1);
    }

    public static void main(String[] args) {
        System.out.println(number("11111"));
    }
}
