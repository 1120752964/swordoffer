package ZuoShen.Class09;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsquence {
    public static void printAllSubsquence(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0);
    }
    //省空间的版本
    public static void process(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
            return;
        }
        process(chs, i + 1);//要当前字符的路
        char tmp = chs[i];//利用系统的栈去记录tmp临时变量
        chs[i] = 0;
        process(chs, i + 1);//不要当前字符的路，因为第i个也就是当前字符被覆盖为0了
        chs[i] = tmp;//这一步还原当前字符，就是回溯，回溯：将条件修改为递归的样子
    }

    public static void function(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0, new ArrayList<Character>());
    }
    //好理解 但是额外空间占用较多的版本
    //i代表从这个树的根往下走的层数，  当前来到i位置，要和不要，走两条路
    //res代表之前的选择所形成的列表
    public static void process(char[] chs, int i, List<Character> res) {
        if(i == chs.length) {
            printList(res);
        }
        List<Character> resKeep = copyList(res);
        resKeep.add(chs[i]);
        process(chs, i+1, resKeep); //要当前字符的路  因为add了当前字符
        List<Character> resNoInclude = copyList(res);
        process(chs, i+1, resNoInclude);//不要当前字符的路
    }

    public static void printList(List<Character> res) {
        // ...;
    }

    public static List<Character> copyList(List<Character> list){
        return null;
    }


    public static void main(String[] args) {
        String test = "abc";
        printAllSubsquence(test);
    }

}
