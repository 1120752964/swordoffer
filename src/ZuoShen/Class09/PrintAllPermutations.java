package ZuoShen.Class09;

import java.util.ArrayList;

public class PrintAllPermutations {
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chs = str.toCharArray();
        process(chs, 0, res);
        res.sort(null);
        return res;
    }
    //chs[i..]范围上，所有的字符，都可以在i位置上，后续都去尝试  类比于a(bc),可以b在第二个，也可以是c
    //chs[0..i-1]范围上，是之前做的选择
    //请把所有的字符串形成的全排列，加入到res里去
    public static void process(char[] chs, int i, ArrayList<String> res) {
        if (i == chs.length) {
            res.add(String.valueOf(chs));
        }
        boolean[] visit = new boolean[26];//代表某一个字符是否尝试过
        for (int j = i; j < chs.length; j++) {
            if (!visit[chs[j] - 'a']) {
                //todo ！！！！为什么要相同的字符不去尝试，因为前面尝试过了
                //todo 对于全排列来说，是否是同一个字符a不重要，重要的是a这种情况已经走过了，这个位置上不允许是a了
                //todo 这就叫做分支限界（剪枝） 提前杀死不可能的路 这个策略不可能中
                visit[chs[j] - 'a'] = true;
                swap(chs, i, j);  //在for循环里去循环剩余的所有节点，每一个都去交换然后递归尝试
                process(chs, i + 1, res);  //因为是全排列，因此i需要自增到长度后结束
                swap(chs, i, j);//在递归结束后要把节点换回去  也就是回溯
            }
        }
    }
    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
