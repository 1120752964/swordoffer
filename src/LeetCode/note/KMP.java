package LeetCode.note;

import java.util.Arrays;

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
        System.out.println(Arrays.toString(next));
        //O(N)  2N?
        //时间复杂度 i1 (N)  i1-i2(N) 去比较三个分支这两个值的变化  相加为2N
        while (i1<str1.length&&i2<str2.length){
            if(str1[i1]==str2[i2]){
                i1++;
                i2++;
            }else if(next[i2]==-1){
                i1++;
            }else {
                i2=next[i2];
            }
        }
       return i2==str2.length?i1-i2:-1;
    }

    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[ms.length];
        next[0]=-1;
        next[1]=0;
        //从2开始比较0和1位置是否相同
        int i=2;
        int cur=0;
        while (i<ms.length){
            if(ms[i-1]==ms[cur]){
                next[i++]=++cur;
            }else if(cur>0){ //cur还能往前走
                cur=next[cur];
            }else {
                //cur==0
                next[i++]=0;
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
