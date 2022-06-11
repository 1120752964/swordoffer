package ZuoShen.Class10;

public class Manacher {
    // 1221 -> #1#2#2#1#
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] charArr = manacherString(str); // 1221 -> #1#2#2#1#
        int[] pArr = new int[charArr.length]; // 回文半径数组
        int C = -1; //中心
        int R = -1; //回文右边界的再往右一个位置，最右的有效区是R-1位置
        int max = Integer.MIN_VALUE; //扩出来的最大值  即结果
        for (int i = 0; i != charArr.length; i++) { //每一个位置都求回文半径
            // i至少的回文区域，先给pArr[i]   min(  i'的半径，R-i)
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            //右边要验的位置和左边要验的位置不越界
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                //至少不用验的区域跳过后，前后的是否一样 （扩）
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
                    //知道第二种情况的第1、2种小情况扩一次就会失败  因此没怎么浪费
                    pArr[i]++;
                else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1; //处理出来的带'#'字符的半径长度为原串长度+1
    }
    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(maxLcpsLength(str1));
    }
}
