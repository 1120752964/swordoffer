package ZuoShen.Class09;

public class Knapsack {
    public static int maxValue1(int[] weights, int[] values, int bag) {
        return process1(weights, values, 0, 0, bag);
    }

    //i... （i往后的） 的货物自由选择，形成最大的价值返回
    //重量永远不要超过bag
    //之前做的决定，所达到的重量--alreadyweight
    public static int process1(int[] weights, int[] values, int i, int alreadyweight, int bag) {
        //弹幕指出的问题：  （看不懂 先不改了）
        //只需要在return中的values[i]之前判断一下,是否超重就好了
        //并且第一个if不需要,还有误导含义,让人以为return 0就是超重价值不累加
//        if (alreadyweight > bag) {
//            return 0;
//        }
        if (i == weights.length) {
            return 0;
        }
        return Math.max(
                //不要第i个货物
                process1(weights, values, i + 1, alreadyweight, bag),
                //要第i个货物  但是应该去做判断吧。。。
                values[i] + process1(weights, values, i + 1, alreadyweight + weights[i], bag));
    }

    public static int maxValue2(int[] c, int[] p, int bag) {
        int[][] dp = new int[c.length + 1][bag + 1];
        for (int i = c.length - 1; i >= 0; i--) {
            for (int j = bag; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + c[i] <= bag) {
                    dp[i][j] = Math.max(dp[i][j], p[i] + dp[i + 1][j + c[i]]);
                }
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        int[] weights = { 3, 2, 4, 7 };
        int[] values = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(maxValue1(weights, values, bag));
        System.out.println(maxValue2(weights, values, bag));
    }
}
