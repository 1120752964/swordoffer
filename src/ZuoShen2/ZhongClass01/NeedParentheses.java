package ZuoShen2.ZhongClass01;

public class NeedParentheses {
    public static int needParentheses(String str) {
        int leftRest = 0;  //需要的右括号  （左边多余的左括号）
        int needSolveRight = 0; //需要的左括号   （需要解决的右括号）
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                leftRest++;
            } else {
                if (leftRest == 0) {
                    needSolveRight++;
                } else {
                    leftRest--;
                }
            }
        }
        return leftRest + needSolveRight;
    }

    public static void main(String args[]) {

    }
}
